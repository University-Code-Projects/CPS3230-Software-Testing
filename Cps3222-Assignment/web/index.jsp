<%--
  Created by IntelliJ IDEA.
  User: jonathan
  Date: 19/12/2016
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Page</title>
</head>
<body>
<h1>Hello World</h1>
<form name="myForm" action="display.jsp" method="POST">
  <table border="0">
    <tbody>
    <tr>
      <th>First Name : </th>
      <th><input type = "text" name = "first" value="" size ="50"></th>
    </tr>
    </tbody>
  </table>
  <input type="submit" value="Submit" name="submit" />
</form>
</body>
</html>
