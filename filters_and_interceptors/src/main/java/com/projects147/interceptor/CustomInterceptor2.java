package com.projects147.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class CustomInterceptor2 implements HandlerInterceptor {

    /**
     * Executed before the actual handler/controller method is called.
     * Used for pre-processing tasks like authentication, authorization, or logging request details.
     * Returns true to continue the request chain, false to block it.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("CustomInterceptor2 - In preHandle");
        return true;
    }

    /**
     * Executed after the handler/controller method completes but before the response is rendered.
     * Useful for post-processing logic like modifying the model/view or adding response headers.
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        log.info("CustomInterceptor2 - In postHandleHandle");
    }

    /**
     * Executed after the response has been sent to the client (final cleanup phase).
     * Used for resource cleanup, performance metrics collection, or exception handling.
     * The exception parameter contains any exception thrown during request processing if one occurred.
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        log.info("CustomInterceptor2 - In afterCompletion");
    }

}
