<%-- 
    Document   : Register
    Created on : 03-Nov-2014, 14:05:22
    Author     : Christopher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <li>Forename <input type="text" name="fname"></li>
                    <li>Surname <input type="text" name="sname"></li>
                    <li>Address <input type="text" name="address"></li>
                    <li>Password <input type="password" name="password"></li>
                </ul>
                <br/>
                <input type="submit" value="Register">
            </form>

        </article>
        <footer>
            <ul>
                <li class="footer"><a href="/Tea2Me">Home</a></li>
            </ul>
        </footer>
    </body>
</html>
