package com.skyeye.skyeyeuserservice.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@RequiredArgsConstructor
public class BearerTokenInterceptor implements HandlerInterceptor {

  private static final String AUTHORIZATION = "Authorization";
  private static final String BEARER = "Bearer";

  private final BearerTokenWrapper tokenWrapper;

  @Override
  public boolean preHandle(HttpServletRequest request,
          HttpServletResponse response, Object handler) {
    final String authorizationHeaderValue = request.getHeader(AUTHORIZATION);
    log.info(String.format("Request with header %s", authorizationHeaderValue));

    if (authorizationHeaderValue != null && authorizationHeaderValue.startsWith(BEARER)) {
      String token = authorizationHeaderValue.substring(7);

      this.tokenWrapper.setToken(token);
    }
    
    return true;
  }
}