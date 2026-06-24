package com.projects147.config;

import com.projects147.interceptor.CustomInterceptor1;
import com.projects147.interceptor.CustomInterceptor2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration class to register custom interceptors in the Spring MVC pipeline.
 * This class implements WebMvcConfigurer to hook into Spring's configuration mechanism.
 * <p>
 * Interceptors are used to intercept HTTP requests/responses before they reach controllers
 * and after they complete. They can perform pre-processing, post-processing, and cleanup tasks.
 */
@Configuration
@RequiredArgsConstructor
@Slf4j
public class InterceptorRegistrationConfig implements WebMvcConfigurer {

    // Inject the custom interceptor bean (defined as @Component in CustomInterceptor1)
    private final CustomInterceptor1 customInterceptor1;
    private final CustomInterceptor2 customInterceptor2;

    /**
     * Override method from WebMvcConfigurer to register interceptors.
     * This method is called during Spring startup to configure the interceptor registry.
     *
     * @param registry The InterceptorRegistry used to register interceptors with path patterns
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Register the custom interceptor
        registry.addInterceptor(customInterceptor1)
                // Pattern "/api/departments/**" matches:
                // - /api/departments (the base path itself)
                // - /api/departments/ (with trailing slash)
                // - /api/departments/1, /api/departments/list (nested paths)
                // Note: * only matches within a path segment, ** matches across segments
                .addPathPatterns("/api/departments/**");
        log.info("Registered CustomInterceptor1 for paths /api/departments/*");

        registry.addInterceptor(customInterceptor2)
                .addPathPatterns("/api/departments/**");
        log.info("Registered CustomInterceptor2 for paths /api/departments/*");
    }
}
