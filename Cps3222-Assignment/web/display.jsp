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
<%!
    private Affiliate a;
    private int id = -1;
    private String pass = "";
    private String name = "";
    private double balance = 0.0;
    private boolean flag = false;
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Account Page</title>
</head>
    <tBody>
    <body>
    <h1>Account Page</h1>
    <form name="myForm" action="display.jsp" method="POST">
        <table border="0">
            <tbody>
            <%
                String idS = request.getParameter("id");//cannot be

                try {
                    id = Integer.parseInt(idS);
                    a = new Affiliate(id, pass);
                    pass = request.getParameter("pass");
                    flag = true;
                } catch(Exception e) {
                    if(id < 0) {
                        id = -1;
                    }
                }

                System.out.println(id);

                //String name = obtained from affiliate
                //double balance =
                AdPlatform plat = new AdPlatform();
                Affiliate aff1 = new Affiliate(1,"pass1","Client1");
                Affiliate aff2 = new Affiliate(2,"pass2","Client2");
                Affiliate aff3 = new Affiliate(3,"pass3","Client3");

                plat.registerAffiliate(aff1);
                plat.registerAffiliate(aff2);
                plat.registerAffiliate(aff3);
                String x = request.getParameter("Withdraw");

                if(flag){
                    a = plat.getAffiliate(id);
                    for (int i = 0; i<9; i++){
                        plat.adClicked(id);
                    }
                    flag = false;
                }

                if("Withdraw".equals(x)){
                    System.out.println("WITHDRAWING");
                    session.setAttribute("balance", balance);
                    System.out.println(balance);
                    session.setAttribute("msg", plat.settleAffiliateBalance(a));
                    balance = a.getBalance();
                    System.out.println(balance);
                    session.setAttribute("newBalance", balance);
                    response.sendRedirect("withdraw.jsp");
                }else if(!plat.validator(a)){//affiliate exists
                    //error message
                    System.out.println("Not Found");
                    response.sendRedirect("error.jsp");
                    return;
                    //System.out.println("didnt redirect");
                }

                name = a.getName();
                balance = a.getBalance();


                //}
            %>

            <tr>
                <td>Affiliate Id : </td>
                <td><%= id %></td>
            </tr>
            <tr>
                <td>Affiliate Name : </td>
                <td><%= name %></td>
            </tr>
            <tr>
                <td>Affiliate Balance : </td>
                <td><%= balance %></td>
            </tr>
            </tbody>
        </table>

        <input type="submit" value="Withdraw" name="Withdraw" />
    </form>
    </body>
</html>