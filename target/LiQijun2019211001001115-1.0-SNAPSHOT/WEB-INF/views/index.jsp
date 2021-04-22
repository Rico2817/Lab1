<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp"%>
<h1><%= "Welcome to Myjsp" %>
</h1>
<form method="get" action="search" target="_blank">
    <label>
        Search<input name="text" value="text" size="30"/>
    </label>
    <label>
        <select name="search">
            <option value="baidu">BaiDu 百度</option>
            <option value="bing">Bing 必应</option>
            <option value="google">Google 谷歌</option>
        </select>
    </label>
    <input type="submit" value="Search"/>
</form>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<br/>
<a href="hello">Student Info Servlet-week2</a>
<br/>
<a href="hello-servlet">Life Cycle Servlet-week3</a>
<br/>
<a href="register.jsp">Register -getParameter-week4</a>
<br/>
<a href="config">Config Parameter -week4</a>
<br/>
<a href="register.jsp">Register JDBC-week4</a>
<br/>
<a href="index.jsp">include -week5</a>
<br/>
<a href="login.jsp">login-week5</a>
<%@include file="footer.jsp"%>