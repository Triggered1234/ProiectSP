package com.example.ProiectSP.difexample;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(2)
public class RequestResponseLoggingFilter implements jakarta.servlet.Filter {

    // Create a logger instance for this class
    private static final Logger logger = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // Log the incoming request details
        logger.info("Logging Request {} : {}", req.getMethod(), req.getRequestURI());

        // Proceed with the filter chain
        chain.doFilter(request, response);

        // Log the outgoing response details
        logger.info("Logging Response: {}", res.getContentType());
    }

    // Additional methods can be added if necessary
}
