package com.projects147.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class CustomFilter2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("CustomFilter2 - Before chain.doFilter");
        chain.doFilter(request, response);
        log.info("CustomFilter2 - After chain.doFilter");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
