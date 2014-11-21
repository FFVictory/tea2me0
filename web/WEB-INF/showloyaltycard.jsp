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
    <style>
        #header {
            background-color:greenyellow;
            color:black;
            text-align:center;
            padding:10px;
        }
        #footer {
            background-color:black;
            color:white;
            clear:both;
            text-align:center;
            padding:15px;
        }
        body {
            color:grey;
            position: absolute;
            left: 30px;
            top: 20px;
            text-align: center;
        }
    </style>
    <title>showloyaltycard </title>
</head>
<body>
<div id="header"><h1>TeaToMe</h1></div>
<div id="footer">
    <p1>TeaToMe  All rights reserved.</p1>
</div>
<%//LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
//if (lg != null) {%>
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
<li><button onclick="javascript:window.location.href='addloyaltycard.jsp'"style="width: 100px; height: 30px;">Back</button> </li>
<%//}else{%>
<li><a href="index.jsp">Login</a></li>
<% //  }%>
</body>
</html>
