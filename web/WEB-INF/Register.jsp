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
    </head>
    <body>
               
        <article>
            <h3>Register a new Staff Member:</h3>
            <form method="POST"  action="Register">
                <ul>
                    <li>Forename <input type="text" name="fname"style="width: 300px; height: 50px;"></li>
                    <li>Surname <input type="text" name="sname" style="width: 300px; height: 50px;"></li>
                    <li>Address <input type="text" name="address"style="width: 300px; height: 50px;"></li>
                    <li>Password <input type="password" name="password" style="width: 300px; height: 50px;"></li>
                    <li>Confirm Password <input type="password" name="confirmPassword"style="width: 300px; height: 50px;"></li>
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
