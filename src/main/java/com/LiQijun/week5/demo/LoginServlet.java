package com.LiQijun.week5.demo;

import com.LiQijun.dao.UserDao;
import com.LiQijun.model.User;

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
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        UserDao userDao=new UserDao();
        try {
            User user= userDao.findByUsernamePassword(con,username,password);//this method use for login;
            if(user != null){
                //valid
                //week 8 code
                //add code for remember me
                String rememberMe=request.getParameter("rememberMe");//1-checked,null if checked
                if(rememberMe!=null && rememberMe.equals("1")){
                    //want to remember me
                    //create 3 cookie
                    Cookie usernameCookie=new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie=new Cookie("cPassword",user.getPassword());
                    Cookie rememberMeCookie=new Cookie("rememberMeVal",rememberMe);

                    //set age of cookie
                    usernameCookie.setMaxAge(5);// 5sec -test
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);
                    //add cookies into response
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }
                //create a session
                HttpSession session=request.getSession();//create a new session if session doesn't exist - otherwise return existing session
                //check session id
                System.out.println("Session id -->"+session.getId());//session id
                //set time for session
                session.setMaxInactiveInterval(10);//for 5 10 section if request not come in -Tomcat kill session -set 60*60==1h
               //week 8 0--change request(one page ) to session -so we can get session attribute in many jsp page - login.jsp and header.jsp
                session.setAttribute("user",user);//set user info
                /*code 1:
                //week 8 code--demo #1 -use cookie for session
                //create cookie
                //step 1:create an object of cookie class
                Cookie c=new Cookie("sessionid",""+user.getId());//sessionid =user.id
                //step 2:set age of cookie
                c.setMaxAge(10*60);//in sec - 10 min--7days--   7*24*60*60
                //step 3:add cookie into response
                response.addCookie(c);*/


                //set user model into request
                //request.setAttribute("user",user);//get user info in jsp
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }else{
                //invalid
                request.setAttribute("message","Username or password was wrong! pls try again!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String u = new String();
        String p = new String();
        PrintWriter print=response.getWriter();
        //find
        try {
            ResultSet rs=con.createStatement().executeQuery("select * from usertable where username ='"+username+"'and password ='"+password+"';");
            if (rs.next()){
                //u = rs.getString("username");
               // p = rs.getString("password");
                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthDate",rs.getString("birthDate"));
                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
            }else{
                request.setAttribute("message","username or password error!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
       // if(u==username&&p==password) print.println("登入成功，welcome,"+username);
       // else print.println("登入失败,pls try again!!");
    }
}
