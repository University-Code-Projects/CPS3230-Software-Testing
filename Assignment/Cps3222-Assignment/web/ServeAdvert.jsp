<%--
  ServeAdvert.jsp was used to mimic an advert, used for performance testing
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
