package com.LiQijun.week4.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
@WebServlet(
        urlPatterns = {"/jdbc"},
        initParams = {
                @WebInitParam(name="driver",value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name="url",value = "jdbc:sqlserver://127.0.0.1:1433;databaseName=userdb;"),
                @WebInitParam(name="user",value = "sa"),
                @WebInitParam(name="password",value = "admin123456"),
        }
)
public class JDBC_DemoServlet extends HttpServlet {
    Connection con = null;  //数据库连接
    @Override
    public void init() throws ServletException {
        super.init();
        ServletConfig config=getServletConfig();
        String driver =config.getInitParameter("driver");// "com.microsoft.sqlserver.jdbc.SQLServerDriver";       //数据库驱动
        String url =config.getInitParameter("url");//"jdbc:sqlserver://127.0.0.1:1433;databaseName=userdb;";
        String user=config.getInitParameter("user");//"sa";
        String password=config.getInitParameter("password");//"admin123456";                          //数据库 URL
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
        System.out.println("I am in doGet()");
        //we need to use con within doGet;
        String sql="select * from usertable";
        try {
            ResultSet rs=con.createStatement().executeQuery(sql);
            while (rs.next()){
                //print
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
