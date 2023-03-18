package com.rejola.BProject.security;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rejola.BProject.exception.InvalidTokenException;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtTokenProvider {

  /**
   * THIS IS NOT A SECURE PRACTICE! For simplicity, we are storing a static key here. Ideally, in a
   * microservices environment, this key would be kept on a config-server.
   */
  @Value("${security.jwt.token.secret-key:secret-key}")
  private String secretKey;

  @Value("${security.jwt.token.expire-length:86400000}")
  private long validityInMilliseconds = 86400000; // 1d

  @PostConstruct
  protected void init() {
    secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
  }

  public String createToken(String username) {

    Claims claims = Jwts.claims().setSubject(username);

    Date now = new Date();
    Date validity = new Date(now.getTime() + validityInMilliseconds);

    return Jwts.builder()//
            .setClaims(claims)//
            .setIssuedAt(now)//
            .setExpiration(validity)//
            .signWith(SignatureAlgorithm.HS256, secretKey)//
            .compact();
  }


  public JsonNode getTokenData(String token) {
    validateToken(token);
    try {
      String tokenData = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
      ObjectMapper mapper = new ObjectMapper();
      return mapper.readValue(tokenData, JsonNode.class);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      throw new InvalidTokenException("Invalid token");
    }


  }

  public String resolveToken(HttpServletRequest req) {

    String bearerToken = req.getHeader("Authorization");
    if(bearerToken == null){
      throw new InvalidTokenException("Invalid Token");
    }
    if (bearerToken.startsWith("Bearer ")) {
      return bearerToken.substring(7);
    }
    return null;
  }

  public boolean validateToken(String token) {
    try {
      Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
      return true;
    }catch (SignatureException ex){
      throw new InvalidTokenException("Invalid JWT signature");
    } catch (MalformedJwtException ex) {
      throw new InvalidTokenException("Invalid JWT token");
    } catch (ExpiredJwtException ex) {
      throw new InvalidTokenException("Expired JWT token");
    } catch (UnsupportedJwtException ex) {
      throw new InvalidTokenException("Unsupported JWT token");
    } catch (IllegalArgumentException ex) {
      throw new InvalidTokenException("JWT claims string is empty.");
    }
  }

}
