<%-- 
    Document   : Register
    Created on : 03-Nov-2014, 14:05:22
    Author     : Christopher
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="stores.LoggedIn"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tea2Me</title>
        <link rel="stylesheet" type="text/css" href="Styles.css" />
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
        <article>
            <h3>Register a new Staff Member:</h3>
            <form method="POST"  action="Register">
                <ul>
                    <li>Forename <input type="text" name="fname"></li>
                    <li>Surname <input type="text" name="sname" ></li>
                    <li>Address <input type="text" name="address"></li>
                    <li>Password <input type="password" name="password" ></li>
                    <li>Confirm Password <input type="password" name="confirmPassword"></li>
                    <%
                        LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
                        if(lg.getPosition()== 3){
                    %>
                    <li>Manager Branch <input type="text" name="managerBranch"style="width: 100px; height: 30px;"></li>
                    <%
                        }
                    %>
                </ul>
                <br/>
                <input type="submit" value="Register"style="width: 100px; height: 30px;">
            </form>

        </article>
        <footer>
            <ul>
                <li class="footer"><a href="/Tea2Me">Home</a></li>
            </ul>
        </footer>
    </body>
</html>
