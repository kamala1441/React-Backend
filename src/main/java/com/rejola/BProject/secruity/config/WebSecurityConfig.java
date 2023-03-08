package com.rejola.BProject.secruity.config;

import com.rejola.BProject.security.JwtTokenFilter;
import com.rejola.BProject.security.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true)
@AllArgsConstructor
public class WebSecurityConfig {

  private JwtTokenProvider jwtTokenProvider;

  private  HandlerExceptionResolver handlerExceptionResolver;
  @Bean
  public JwtTokenFilter jwtTokenFilter() {
    return new JwtTokenFilter(jwtTokenProvider, handlerExceptionResolver);
  }
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    // Disable CSRF (cross site request forgery)
      http.csrf().disable();
    //http.csrf().and();

    // No session will be created or used by spring security
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
   // http.exceptionHandling().authenticationEntryPoint(unauthorizedHandler);
    // Entry points
//    http.authorizeRequests()//
//            .antMatchers("/auth/login","/auth/forgot").permitAll()//
//          //  .antMatchers("/v1/**").permitAll()//
//            // Disallow everything else..
//            .anyRequest().authenticated();

     http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }

  @Bean
  public FilterRegistrationBean platformCorsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

    CorsConfiguration configAutenticacao = new CorsConfiguration();
    configAutenticacao.setAllowCredentials(true);
    configAutenticacao.addAllowedOrigin("http://localhost:3000");
    configAutenticacao.addAllowedHeader("Authorization");
    configAutenticacao.addAllowedHeader("Content-Type");
    configAutenticacao.addAllowedHeader("Accept");
    configAutenticacao.addAllowedMethod("POST");
    configAutenticacao.addAllowedMethod("GET");
    configAutenticacao.addAllowedMethod("DELETE");
    configAutenticacao.addAllowedMethod("PUT");
    configAutenticacao.addAllowedMethod("OPTIONS");
    configAutenticacao.setMaxAge(3600L);
    source.registerCorsConfiguration("/**", configAutenticacao);

    FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
    bean.setOrder(-110);
    return bean;
  }



}
