<%@ page import="com.LiQijun.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/15
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>
    User Info
</h1>
<%
    Cookie [] allCookies= request.getCookies();//all cookies
    for(Cookie c:allCookies){
        //get one by one
        out.println("<br/>"+c.getName()+"---"+c.getValue());
    }
%>
<%
    User u= (User)session.getAttribute("user");
%>
<table>
    <tr><td>username:</td><td><%=u.getUsername()%></td></tr>
    <tr><td>password:</td><td><%=u.getPassword()%></td></tr>
    <tr><td>email:</td><td><%=u.getEmail()%></td></tr>
    <tr><td>gender:</td><td><%=u.getGender()%></td></tr>
    <tr><td>birthDate:</td><td><%=u.getBirthDate()%></td></tr>
</table>
<%@include file="footer.jsp"%>