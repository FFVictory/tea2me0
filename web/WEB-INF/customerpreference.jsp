<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/11/20
  Time: 3:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="stores.*" %>
<html>
<head>
    <title>customerPreference</title>
</head>
<body>
<%
    // LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
    // if (lg != null) {%>


<form method="POST"  action="CPreference">
    <ul>
        <li>
            Career <select name="career">
            <option>Choose a Category</option>
            <option value="A">Doctor//Dentist/Lawyer</option>
            <option value="B">Teacher/Professor/Civil Servant</option>
            <option value="C">White Collar</option>
            <option value="D">Farmer/Worker/Individual Business/Staff</option>
            <option value="E">Student</option>
            <option value="F">Other</option>
        </select>
        </li>
       <!-- <li>DateOfBirth(Y-M-D) <input type="DATE" name="dob1">to<input type="DATE" name="dob2"></li>-->
    </ul>
    <br/>
    <input type="submit" value="GeneratePreferenceReport">
</form>



<%//}else{%>
<li><a href="index.jsp">Login</a></li>
<% //  }%>
</body>
</html>
