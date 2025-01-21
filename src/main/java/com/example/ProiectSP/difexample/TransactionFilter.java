package com.example.ProiectSP.difexample;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class TransactionFilter implements jakarta.servlet.Filter {

    // Create a logger instance for this class
    private static final Logger logger = LoggerFactory.getLogger(TransactionFilter.class);

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;

        // Log the beginning of the transaction
        logger.info("Starting a transaction for request: {}", req.getRequestURI());

        // Proceed with the rest of the filter chain
        chain.doFilter(request, response);

        // Log the end of the transaction
        logger.info("Committing a transaction for request: {}", req.getRequestURI());
    }
}

