<%--
  Created by IntelliJ IDEA.
  User: jonathan
  Date: 19/12/2016
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
    <body>
    <h1>Hello World</h1>
    <%
        String firstName = request.getParameter("first");
        System.out.println(firstName);
    %>
    </body>
</html>