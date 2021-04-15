package com.LiQijun.week6.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

@WebListener
public class JDBCServletContextListenner implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context= sce.getServletContext();

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
            Connection con= DriverManager.getConnection(url,user,password);
            System.out.println("SqlServer数据库连接成功！"+con);
            System.out.println("i am in contextInitialized");
            context.setAttribute("con",con);
        }catch (Exception e){
            String[] infos = { "未能成功连接数据库！", "请确认本软件是否已经运行！" };
            JOptionPane.showMessageDialog(null, infos);
            System.exit(0);
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("i am in contextDestroyed");
        sce.getServletContext().removeAttribute("con");
    }
}
