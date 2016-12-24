<%--
  Created by IntelliJ IDEA.
  User: jonathan
  Date: 19/12/2016
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>

<%@ page import ="cps.uom.edu.*" contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@ page import= "cps.uom.edu.AdPlatform" %>
<jsp:useBean id="obj" class="cps.uom.edu.AdPlatform"/>
<jsp:setProperty name="obj" property="*"/>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
</head>
    <tBody>
    <body>
    <h1>Account Page</h1>
    <form name="myForm" action="display.jsp" method="POST">
        <table border="0">
            <tbody>
            <%
                String idS = request.getParameter("id");//cannot be empty
                int id = Integer.parseInt(idS);
                String pass = request.getParameter("pass");
                Affiliate a = new Affiliate(id, pass);
                //String name = obtained from affiliate
                //double balance =
                AdPlatform plat = new AdPlatform();
                Affiliate aff1 = new Affiliate(1,"pass1");
                Affiliate aff2 = new Affiliate(2,"pass2");
                Affiliate aff3 = new Affiliate(3,"pass3");

                plat.registerAffiliate(aff1);
                plat.registerAffiliate(aff2);
                plat.registerAffiliate(aff3);
                if(!plat.validator(a)){//affiliate exists
                    //error message
                    System.out.println("Not Found");
                    response.sendRedirect("error.jsp");
                }
                //String idS = request.getParameter("id");//cannot be empty
                //int id = Integer.parseInt(idS);
                //String pass = request.getParameter("pass");
                //String name = obtained from affiliate
                //double balance =
            %>

            <tr>
                <td>Affiliate Id : </td>
                <td><%= id %></td>
            </tr>
            <tr>
                <td>Affiliate Balance : </td>
                <td><%= pass %></td>
            </tr>
            </tbody>
        </table>
        <input type="button" value="Withdraw" name="withdraw" />
    </form>
    </body>
</html>