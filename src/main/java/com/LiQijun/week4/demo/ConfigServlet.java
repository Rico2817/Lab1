package com.LiQijun.week4.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ConfigServlet extends HttpServlet {
    /*ServletConfig config =getServletConfig();
    String name =null;
    String studentID= null;
    public void init() {
        name = "Liqijun";//config.getInitParameter("name") ;
        studentID= "2019211001001115"; //config.getInitParameter("studentID");;
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><body>");
        writer.println("<br> username :"+name);
        writer.println("<br> password :"+studentID);
        writer.println("</body></html>");
        writer.close();
    }*/
    ServletConfig config =getServletConfig();
    private String name ;
    private String studentID;

    public void init() {
        name = "Liqijun";//config.getInitParameter("name") ;
        studentID= "2019211001001115"; //config.getInitParameter("studentID");;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello.
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println("<br> name :"+name);
        writer.println("<br> studentID :"+studentID);
        writer.println("</body></html>");
        writer.close();
    }

    public void destroy() {
    }
}
