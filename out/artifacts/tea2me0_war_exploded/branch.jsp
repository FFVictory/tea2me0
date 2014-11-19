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
  Choose your country : <select name="country">
    <option value="UK">United Kingdom</option>
    <option value="United States Of America">United States Of America</option>
    <option value="Finland">Finland</option>
    <option value="Russia">Russia</option>
    <option value="Netherlands">Netherlands</option>
    <option value="China">China</option>
  </select> <br>
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
