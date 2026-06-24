package com.projects147.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/*
 * CustomFilter1 logs when a request enters and exits this filter.
 * Useful for tracing request flow relative to other registered filters.
 */
@Slf4j
public class CustomFilter1 implements Filter {

    /**
     * Called once by the servlet container when the filter is instantiated.
     * Use this to perform one-time initialisation (resource allocation or configuration).
     * Keep initialisation quick — heavy work should be deferred or done asynchronously.
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // No custom init logic required for this simple example; delegate to parent.
        Filter.super.init(filterConfig);
    }

    /**
     * Core filtering logic:
     * - Executed for each matching request on the configured URL patterns.
     * - Logs before and after invoking the next element in the filter chain.
     * - MUST call chain.doFilter(request, response) to allow the request to proceed.
     * - Be mindful of thread-safety: filter instances are shared across threads.
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("CustomFilter1 - Before chain.doFilter");
        // Continue processing the chain (next filter or target servlet/controller)
        chain.doFilter(request, response);
        // Post-processing after downstream filters/servlet have executed
        log.info("CustomFilter1 - After chain.doFilter");
    }

    /**
     * Called when the filter is being taken out of service (e.g., application shutdown).
     * Use this to clean up resources allocated in init().
     */
    @Override
    public void destroy() {
        // No custom cleanup needed for this example; delegate to parent.
        Filter.super.destroy();
    }
}
