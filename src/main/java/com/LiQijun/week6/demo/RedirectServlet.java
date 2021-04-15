package com.LiQijun.week6.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RedirectServlet", value = "/redirect")
public class RedirectServlet extends HttpServlet {
/*    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // redirect -same server-Redirect URL
        //1.start without/
        System.out.println("Before redirect ");

        //response.sendRedirect("index.jsp");
        //http://localhost:8080/2019211001001115LiQijun_war_exploded/redirect
        //http://localhost:8080/2019211001001115LiQijun_war_exploded/index.jsp
        System.out.println("After redirect");
        //2.start with /
        //response.sendRedirect("/2019211001001115LiQijun_war_exploded/index.jsp");
        //http://localhost:8080/2019211001001115LiQijun_war_exploded/redirect
        //http://localhost:8080/index.jsp

        //redirect -another server -Absolute URL
        response.sendRedirect("http://www.baidu.com");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }*/
}
