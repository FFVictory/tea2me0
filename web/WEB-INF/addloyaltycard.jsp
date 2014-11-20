<%--
  Created by IntelliJ IDEA.
  User: Kunjia
  Date: 2014/11/19
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="stores.*" %>
<html>
<head>
    <title>addloyaltycard</title>
</head>
<body>
<%
LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
    if (lg != null) {%>
<article>
    <h3>Register a new LoyaltyCard:</h3>
    <form method="POST"  action="AddLoyaltyCard">
        <ul>
            <li>First name <input type="text" name="fname"></li>
            <li>Last name <input type="text" name="lname"></li>
            <li>City <input type="text" name="city"></li>
            <li>
                Career <select name="career">
                <option value="A">Doctor//Dentist/Lawyer</option>
                <option value="B">Teacher/Professor/Civil Servant</option>
                <option value="C">White Collar</option>
                <option value="D">Farmer/Worker/Individual Business/Staff</option>
                <option value="E">Student</option>
                <option value="F">Other</option>
            </select>
            </li>
            <li>DateOfBirth(Y-M-D) <input type="DATE" name="dob"></li>
            <li>
            Gender <select name="gender">
            <option value="male">Male</option>
            <option value="female">Female</option>
            </select>
            </li>

        </ul>
        <br/>
        <input type="submit" value="Finish">
    </form>

</article>
<footer>
    <ul>
        <li class="footer"><a href="/Tea2Me">Home</a></li>
    </ul>
    <%}else{%>
    <li><a href="index.jsp">Login</a></li>
    <%   }%>
</footer>
</body>
</html>
