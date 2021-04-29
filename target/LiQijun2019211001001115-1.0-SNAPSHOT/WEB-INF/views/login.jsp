<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/7
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>>
<h1>
    Login
</h1>
<%
    if(request.getAttribute("message")!=null){
        out.println(request.getAttribute("message"));
    }
%>
<%
    //read cookie
    Cookie[] allCookies=request.getCookies();
    String username = null,password = null,rememberMeVal = null;
    if(allCookies!=null){
        // get one by one
        for(Cookie c:allCookies){
            if(c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if(c.getName().equals("cPassword")){
                password=c.getValue();
            }
            if(c.getName().equals("rememberMeVal")){
                rememberMeVal=c.getValue();
            }
        }
    }
%>
<form method="post" action="login">
    username<input type="text" name="username" value="<%=username%>"/><br/>
    password<input type="password" name="password" value="<%=password%>>"/><br/>
    <input type="checkbox" name="rememberMe" value="1"<%=rememberMeVal.equals("1")?"checked":""%>>Remember Me<br/>
    <input type="submit" value="Submit"/>

</form>
<%@include file="footer.jsp"%>>
