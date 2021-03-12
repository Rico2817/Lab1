package com.LiQijun.week2.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//its just a java class
//extend HttpServlet
public class HelloWorld extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //when client request method is GET-here-inside doGet()
        //we want to send hello to client
        PrintWriter writer=response.getWriter();
        writer.println("Hello Client !!!");//hello
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        //when client request method is GET-here-inside doGet()

    }
}
