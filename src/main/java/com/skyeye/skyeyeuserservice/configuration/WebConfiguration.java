package com.skyeye.skyeyeuserservice.configuration;

import com.skyeye.skyeyeuserservice.interceptor.BearerTokenInterceptor;
import com.skyeye.skyeyeuserservice.interceptor.BearerTokenWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(bearerTokenInterceptor()).addPathPatterns("/user-api/*");
  }

  @Bean
  public BearerTokenInterceptor bearerTokenInterceptor() {
    return new BearerTokenInterceptor(bearerTokenWrapper());
  }

  @Bean
  @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
  public BearerTokenWrapper bearerTokenWrapper() {
    return new BearerTokenWrapper();
  }
}