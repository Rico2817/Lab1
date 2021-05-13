package com.LiQijun.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName="HelloFilter",
        urlPatterns={"/home","/login","/register.jsp"}
)
//task 1: url /hello-filter is only for on Servlet --HelloServlet
//task 2: url /*-this filter of for all servlet
//task 3: 3 url -this filter for these 3 url only
public class HelloFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("I am in HelloFilter-->init()");//when called?
        //-start tomcat
    }

    public void destroy() {
        System.out.println("I am in HelloFilter-->destroy()");//when called?
        //-stop tomcat
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //REQUEST come here-before go to servlet -doGet() or doPost()
        System.out.println("I am in HelloFilter-->doFilter()--before servlet-request come here");//when called?
        chain.doFilter(request, response);//call next filter// if no next filter --than go to servlet
        System.out.println("I am in HelloFilter-->doFilter()--after servlet-request come here");
    }
}
