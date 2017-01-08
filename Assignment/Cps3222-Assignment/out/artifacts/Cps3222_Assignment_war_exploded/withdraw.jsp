<%--
  Created by IntelliJ IDEA.
  User: jonathan
  Date: 29/12/2016
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page import ="cps.uom.edu.*" contentType="text/html" pageEncoding="UTF-8" language="java"%>
<jsp:useBean id="obj" class="cps.uom.edu.AdPlatform"/>
<jsp:setProperty name="obj" property="*"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Withdraw</title>
</head>
<%!
    private String name = "";
    private double balance = 0.0;
    private double newBalance;
    private String msg;
%>
<body>
<h1>Withdraw Page</h1>
<form name="myForm" action="display.jsp" method="POST">
    <table border="0">
        <tbody>
        <tr>
            <td>Balance</td>
            <td>|Message-Type</td>
            <td>|New-Balance</td>
        </tr>
        <%
            if(Boolean.parseBoolean(session.getAttribute("msg").toString())){
                msg = "Success";
            }else{
                msg = "Error";
            }
            balance = Double.parseDouble(session.getAttribute("balance").toString());
            newBalance = Double.parseDouble(session.getAttribute("newBalance").toString());
            String x = request.getParameter("Submit");
            if("Submit".equals(x)){
                response.sendRedirect("display.jsp");
            }
        %>
        <tr>
            <td class="balance"><%= balance %></td>
            <td class="msg">|<%= msg %> </td>
            <td class="newBalance">|<%= newBalance %> </td>
        </tr>
        </tbody>
    </table>
    <input type="submit" value="Submit" name="Submit" />
</form>

</body>
</html>
