package com.rejola.BProject.security;

import com.rejola.BProject.master.user.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenFilter extends OncePerRequestFilter {

	public JwtTokenFilter(JwtTokenProvider jwtTokenProvider, HandlerExceptionResolver handlerExceptionResolver) {
		this.handlerExceptionResolver = handlerExceptionResolver;
		this.jwtTokenProvider = jwtTokenProvider;
	}

    private  JwtTokenProvider jwtTokenProvider;
    private  HandlerExceptionResolver handlerExceptionResolver;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return true;
        //return Arrays.asList("/v1/auth/login", "/v1/auth/forgot", "/v1/auth/password/reset").contains(request.getRequestURI());
        // Objects.equals(request.getRequestURI(), "/auth/login");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try{
            String bearerToken = httpServletRequest.getHeader("Authorization");
            String token = jwtTokenProvider.resolveToken(httpServletRequest);
            if (token != null && jwtTokenProvider.validateToken(token)) {
//                logger.info("token valid:"+ token);
                UserDetails userDetails =  UserPrincipal.create(new User("fa57b73a-6880-4c1d-a531-9c5bd1aead50"
                        , "kamala", "kamalaroy95@gmail.com", "kamala roy"));
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(authentication);
                filterChain.doFilter(httpServletRequest, httpServletResponse);
            } else {
                logger.info("token invalid");
            }
        }catch (Exception e){
            handlerExceptionResolver.resolveException(httpServletRequest, httpServletResponse, null, e);
            logger.error("filter "+e);
        }



    }


}
