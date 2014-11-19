<%--
  Created by IntelliJ IDEA.
  User: Drew
  Date: 18/11/2014
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/Search" method="get">
    <br>
  City : <input type="text" name="city"><br>
  BranchId : <input type="text" name="branchId"><br>
  <input type="submit" value="Search">
</form>
<br>
<form action="/Logout" method="post">
  <input type="submit" value="Logout">
</form>
<br>
</body>
</html>
