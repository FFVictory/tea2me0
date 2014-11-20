<%@ page import="stores.Loyaltycard" %>
<%--
  Created by IntelliJ IDEA.
  User: KJ
  Date: 2014/11/19
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="stores.*" %>
<html>
<head>
    <title>showloyaltycard</title>
</head>
<body>
<%LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
if (lg != null) {%>
<% Loyaltycard l = new Loyaltycard();
    l=(Loyaltycard)session.getAttribute("Lcard");
%>
New Loyalty Card
<li>LoyaltyCardID:</li><%=l.getID()%><br>
<li>FirstName:</li><%=l.getFname()%><br>
<li>LastName:</li><%=l.getLname()%><br>
<li>Gender:</li><%=l.getGender()%><br>
<li>City:</li><%=l.getCity()%><br>
<li>Career:</li><%=l.getCareer()%><br>
<li>DateOfBirth:</li><%=l.getDateOfBirth()%><br>
<li>BonusPoints:0</li><br>
<li><button onclick="javascript:window.location.href='addloyaltycard.jsp'">Back</button> </li>
<%}else{%>
<li><a href="index.jsp">Login</a></li>
<%   }%>
</body>
</html>
