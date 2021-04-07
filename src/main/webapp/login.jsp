<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/7
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>>
<form method="post" action="/register">
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    <input type="submit" value="Login"/>

</form>
<%@include file="footer.jsp"%>>
