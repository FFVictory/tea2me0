<%--
  Created by IntelliJ IDEA.
  User: Drew
  Date: 21/11/2014
  Time: 06:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
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
</head>
<body>
<div id="header"><h1>TeaToMe</h1></div>
<div id="footer">
    <p1>TeaToMe  All rights reserved.</p1>
</div>
<form action="/GeoPolitical">
    <input type="submit" value="List Of Countries"style="width: 300px; height: 50px;">
</form>
<form action="/AddGeoPolitic">
    <input type="submit" value="Add Country"style="width: 300px; height: 50px;">
</form>
</body>
</html>
