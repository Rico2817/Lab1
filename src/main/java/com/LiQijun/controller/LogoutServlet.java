package com.LiQijun.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/Logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //when user click logout -- method is get
        //kill session
        //false means get existing session
        request.getSession(false).invalidate();//kill session right now
        request.setAttribute("message","you have successfully logged out.");
        request.getRequestDispatcher("WEB-INFO/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
