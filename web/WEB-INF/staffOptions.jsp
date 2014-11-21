<%--
  Created by IntelliJ IDEA.
  User: Christopher
  Date: 20/11/2014
  Time: 15:34
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
    <title></title>
</head>
<body>
<div id="header"><h1>TeaToMe</h1></div>
<div id="footer">
    <p1>TeaToMe  All rights reserved.</p1>
</div>
<form action="/Staff">
    <input type="submit" name="Staff" value="View Staff" style="width: 300px; height: 50px;">
</form>
<form action="/Register" method="GET">
    <input type="submit" name="Register" value="Register a New Staff Member" style="width: 300px; height: 50px;">
</form>
<form action="/DeleteStaff">
    <input type="submit" name="DeleteStaff" value="Delete a Member of Staff"style="width: 300px; height: 50px;">
</form>
<form action="/Logout" method="post"style="width: 100px; height: 30px;">
    <input type="submit" value="Logout"style="width: 100px; height: 30px;">
</form>
</body>
</html>
