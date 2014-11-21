<%-- 
    Document   : index
    Created on : Sep 28, 2014, 7:01:44 PM
    Author     : Administrator
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="global.css"/>

<!DOCTYPE html>
<html>
<head>
    <title>Tea2Me</title>
    <link rel="stylesheet" type="text/css" href="../../../teaToMe/web/Styles.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        text-align: center;}

    </style>
</head>
<body>
<div id="header"><h1>TeaToMe</h1></div>
<div id="footer">
    <p1>TeaToMe  All rights reserved.</p1>
</div>

    <h1>Login</h1>
    <form method="POST" action="Login">
        <ul>
            <li>User Name <input type="text" name="username"style="width: 300px; height: 50px;"></li>
            <li>Password <input type="password" name="password"style="width: 300px; height: 50px;"></li>
        </ul>
        <br/>
        <input type="submit" value="Login"style="width: 100px; height: 30px;">
    </form>

<form action="/Logout" method="post"style="width: 100px; height: 30px;">
    <input type="submit" value="Logout"style="width: 100px; height: 30px;">
</form>
</body>
</html>
