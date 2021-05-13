package com.LiQijun.week3.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.swing.*;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(urlPatterns = {"/register"},loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {
    Connection con =null;

    @Override
    public void init() throws ServletException {
        super.init();
        /*String url ="jdbc:sqlserver://127.0.0.1:1433;databaseName=userdb;";
        String user="sa";
        String password="admin123456";                          //数据库 URL
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("SqlServer数据库驱动连接成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            con= DriverManager.getConnection(url,user,password);
            System.out.println("SqlServer数据库连接成功！"+con);
        }catch (Exception e){
            String[] infos = { "未能成功连接数据库！", "请确认本软件是否已经运行！" };
            JOptionPane.showMessageDialog(null, infos);
            System.exit(0);
            e.printStackTrace();
        }*/
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");//name of input type
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String birthDate=request.getParameter("birthDate");

        try{
            Statement statement=con.createStatement();
            String sql="insert into usertable(username,password,email,gender,birthDate)"+
                    "values('"+username+"','"+password+"','"+email+"','"+gender+"','"+birthDate+"')";
            System.out.println("sql "+sql);

            int n=statement.executeUpdate(sql);
            System.out.println("n:"+n);

            /*sql="select id,username,password,email,gender,birthDate from usertable";
            ResultSet rs = statement.executeQuery(sql);
            PrintWriter out =response.getWriter();
            out.println("<html><title></title><body><table border=1><tr>");
            out.println("<td>username</td>password<td></td>email<td>gender</td><td>birthDate</td></tr>");
            while (rs.next()){
                out.println("<tr>");
                out.println("<td>"+rs.getString("username")+"</td>");
                out.println("<td>"+rs.getString("password")+"</td>");
                out.println("<td>"+rs.getString("email")+"</td>");
                out.println("<td>"+rs.getString("gender")+"</td>");
                out.println("<td>"+rs.getString("birthDate")+"</td>");
                out.println("</tr>");
            }
            out.println("</table></body></html>");
            request.setAttribute("rsname",rs);

            request.getRequestDispatcher("userList.jsp").forward(request,response);
            System.out.println("I am in RegisterServlet doPost() after forward()");*/
            //week -9
            response.sendRedirect("login.jsp");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
