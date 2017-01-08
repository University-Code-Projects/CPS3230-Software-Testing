<%--
  Display.jsp used to show the affiliated information, withdraw button and the ad button
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
    private String pass = null;
    private String name = "";
    private double balance = 0.0;
    private boolean flag = false;
    AdPlatform plat = new AdPlatform();
    Affiliate aff1 = new Affiliate(1,"pass1","Client1");
    Affiliate aff2 = new Affiliate(2,"pass2","Client2");
    Affiliate aff3 = new Affiliate(3,"pass3","Client3");
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
                    pass = request.getParameter("pass");
                    flag = true;
                } catch(Exception e) {
                    if(id < 0) {
                        id = -1;
                    }
                }

                String x = request.getParameter("Withdraw");
                String y = request.getParameter("Ad");
                if(flag){
                    plat.registerAffiliate(aff1);
                    plat.registerAffiliate(aff2);
                    plat.registerAffiliate(aff3);
                    a = new Affiliate(id,pass,"");
                    if(plat.validator(a)){
                        a = plat.getAffiliate(id);
                    }else{
                        //error message
                        System.out.println("Not Found");
                        response.sendRedirect("error.jsp");
                        return;
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
                }

                if ("Ad".equals(y)){
                    plat.adClicked(id);
                    plat.updateAffiliate(a);
                    balance = a.getBalance();
                    System.out.println(balance);
                }
                name = a.getName();
                balance = a.getBalance();
            %>

            <tr>
                <td>Affiliate Id : </td>
                <td class="id"><%= id %></td>
            </tr>
            <tr>
                <td>Affiliate Name : </td>
                <td class="name"><%= name %></td>
            </tr>
            <tr>
                <td>Affiliate Balance : </td>
                <td class="balance"> <%= balance %></td>
            </tr>
            </tbody>
        </table>
        <input type="submit" value="Withdraw" name="Withdraw" />
        <input type="submit" value="Ad" name="Ad" />
    </form>
    </body>
</html>