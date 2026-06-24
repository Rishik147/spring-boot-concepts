package com.projects147.config;

import com.projects147.filter.CustomFilter1;
import com.projects147.filter.CustomFilter2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<CustomFilter1> customFilter1() {
        FilterRegistrationBean<CustomFilter1> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new CustomFilter1());
        filterRegistrationBean.addUrlPatterns("/api/departments/*");
        filterRegistrationBean.setOrder(2);
        log.info("Registered CustomFilter1");
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<CustomFilter2> customFilter2() {
        FilterRegistrationBean<CustomFilter2> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new CustomFilter2());
        filterRegistrationBean.addUrlPatterns("/api/departments/*");
        filterRegistrationBean.setOrder(1);
        log.info("Registered CustomFilter2");
        return filterRegistrationBean;
    }

}
