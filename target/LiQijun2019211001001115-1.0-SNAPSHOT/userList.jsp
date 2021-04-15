<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/15
  Time: 0:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<%@ page import="java.sql.ResultSet"%>

<h1>User List</h1>
<table border="1">
    <tr>
        <td>username</td><td>password</td><td>email</td><td>gender</td><td>birthDate</td>
    </tr>\
    <%
        ResultSet rs = (ResultSet) request.getAttribute("rsname");
        if(rs== null){
    %>
    <tr>
        <td> No Data!</td>
    </tr>
    <%
        }else{
            while (rs.next()){
                out.println("<tr>");
                out.println("<td>"+rs.getInt("id")+"</td>");
                out.println("<td>"+rs.getString("username")+"</td>");
                out.println("<td>"+rs.getString("password")+"</td>");
                out.println("<td>"+rs.getString("email")+"</td>");
                out.println("<td>"+rs.getString("gender")+"</td>");
                out.println("<td>"+rs.getString("birthDate")+"</td>");
                out.println("</tr>");
            }
        }
    %>
</table>
<%@ include file="footer.jsp"%>