package com.LiQijun.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("I am in AuthFilter-->doFilter()--before servlet-request come here");//when called?
        chain.doFilter(request, response);//call next filter// if no next filter --than go to servlet
        System.out.println("I am in AuthFilter-->doFilter()--after servlet-request come here");

    }
}
