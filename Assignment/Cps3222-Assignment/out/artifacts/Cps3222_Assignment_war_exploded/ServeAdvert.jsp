<%--
  Created by IntelliJ IDEA.
  User: jonathan
  Date: 06/01/2017
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>

<%@ page import ="cps.uom.edu.*" contentType="text/html" pageEncoding="UTF-8" language="java"%>
<jsp:useBean id="obj" class="cps.uom.edu.AdPlatform"/>
<jsp:setProperty name="obj" property="*"/>

<html>
<%!
    AdPlatform plat = new AdPlatform();
    Keywords keys = new Keywords();
    AdFormat format = null;
    AdDescription desc = new AdDescription(format, keys);
%>
<head>
    <title>ServeAdvert</title>
</head>
<body>
    <%
        if(plat.serveAdvert(desc)){
            System.out.println("ADVERT SERVED");
        }else{
            System.out.println("ADVERT NOT SERVED");
        }
    %>
    <tr>
        <th>ADVERT </th>
        <td> <%= "BUY THIS SOFT DRINK AND BURGER"  %></td>
    </tr>
</body>
</html>
