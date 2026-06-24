package com.projects147.config;

import com.projects147.filter.CustomFilter1;
import com.projects147.filter.CustomFilter2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FilterConfig registers servlet filters and defines their URL patterns and execution order.
 * CustomFilter2 is registered with order 1 (executes before CustomFilter1),
 * while CustomFilter1 has order 2 (executes after CustomFilter2).
 */
@Configuration
@Slf4j
public class FilterConfig {

    /**
     * Creates a FilterRegistrationBean for CustomFilter1.
     * - Instantiates the filter and registers it with the servlet container.
     * - addUrlPatterns limits the filter to department-related API endpoints.
     * - setOrder(2) places this filter after any filters with a lower order value.
     * Returning FilterRegistrationBean allows further customization if needed.
     */
    @Bean
    public FilterRegistrationBean<CustomFilter1> customFilter1() {
        FilterRegistrationBean<CustomFilter1> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new CustomFilter1());
        // Apply to department endpoints only
        filterRegistrationBean.addUrlPatterns("/api/departments/*");
        // Lower order values run first; this one runs after CustomFilter2 (order 1)
        filterRegistrationBean.setOrder(2);
        log.info("Registered CustomFilter1");
        return filterRegistrationBean;
    }

    /**
     * Creates a FilterRegistrationBean for CustomFilter2.
     * - This filter is registered with order 1 so it executes before CustomFilter1.
     * - Keep filters focused and lightweight; complex logic is better handled in controllers/services.
     */
    @Bean
    public FilterRegistrationBean<CustomFilter2> customFilter2() {
        FilterRegistrationBean<CustomFilter2> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new CustomFilter2());
        filterRegistrationBean.addUrlPatterns("/api/departments/*");
        // Run this filter first for matching requests
        filterRegistrationBean.setOrder(1);
        log.info("Registered CustomFilter2");
        return filterRegistrationBean;
    }

}
