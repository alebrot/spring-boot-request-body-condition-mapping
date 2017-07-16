package com.khlebtsov.spring_boot_request_body_condition_mapping.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by khlebtsov on 7/16/2017.
 */
@Component
public class CachingHttpServletRequestFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest currentRequest = (HttpServletRequest) servletRequest;
        CachingHttpServletRequestWrapper wrappedRequest = new CachingHttpServletRequestWrapper(currentRequest);
        filterChain.doFilter(wrappedRequest, servletResponse);
    }
}
