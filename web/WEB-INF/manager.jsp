<%--
  Created by IntelliJ IDEA.
  User: Drew
  Date: 17/11/2014
  Time: 18:13
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
<form action="/Sale">
    <input type="submit" name="sale" value="Sale"style="width: 300px; height: 50px;"><br>
</form>
<form action="/StaffOptions">
    <input type="submit" name="staff" value="Staff"style="width: 300px; height: 50px;"><br>
</form>
<form action="/Stock">
    <input type="submit" name="stock" value="Stock"style="width: 300px; height: 50px;"><br>
</form>
<form action="/Logout" method="post">
    <input type="submit" value="Logout"style="width: 100px; height: 30px;">
</form>

</body>
</html>
