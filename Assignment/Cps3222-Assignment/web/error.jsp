<%--
  Error.jsp used to indicate an incorrect login was made
--%>
<%@ page import ="cps.uom.edu.*" contentType="text/html" pageEncoding="UTF-8" language="java"%>
<jsp:useBean id="obj" class="cps.uom.edu.AdPlatform"/>
<jsp:setProperty name="obj" property="*"/>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
</head>
<body>
<h1>Login Page</h1>
<script>
    alert("ID or password are incorrect")
</script>
<form name="myForm" action="display.jsp" method="POST">
    <table border="0">
        <tbody>
        <tr>
            <th>Affiliate Id : </th>
            <th><input type = "text" name = "id" value="" size ="30"></th>
        </tr>
        <tr>
            <th>Affiliate password : </th>
            <th><input type = "password" name = "pass" value="" size ="30"></th>
        </tr>
        </tbody>
    </table>
    <input type="submit" value="Submit" name="submit" />
</form>
</body>
</html>