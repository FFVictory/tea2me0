<%--
  Created by IntelliJ IDEA.
  User: Drew
  Date: 21/11/2014
  Time: 03:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
  <link rel="shortcut icon" href="favicon.ico"/>
  <link rel="stylesheet" type="text/css" href="/style.css"/>
</head>
<body>
<div id="header"><h1>TeaToMe</h1></div>
<div id="footer">
    <p1>TeaToMe  All rights reserved.</p1>
</div>
<form action="/rtSale" method="post" >
  <input type="submit" value="Real-time Transactions"style="width: 300px; height: 50px;">
</form>
<button onclick="window.location='addloyaltycard.jsp'" style="width: 300px; height: 50px;">LoyaltyCard</button>
</body>
</html>
