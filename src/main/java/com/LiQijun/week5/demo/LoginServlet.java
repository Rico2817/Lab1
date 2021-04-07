package com.LiQijun.week5.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;  //数据库连接
    @Override
    public void init() throws ServletException {
        super.init();

        ServletConfig config=getServletConfig();
        String driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";       //数据库驱动
        String url ="jdbc:sqlserver://127.0.0.1:1433;databaseName=userdb;";
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
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String u = new String();
        String p = new String();
        PrintWriter print=response.getWriter();
        //find
        try {
            ResultSet rs=con.createStatement().executeQuery("select * from usertable where username ="+username+"and password ="+password+";");
            while (rs.next()){
                u = rs.getString(1);
                p = rs.getString(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(u==username&&p==password) print.println("登入成功，welcome,"+username);
        else print.println("登入失败,pls try again!!");
    }
}
