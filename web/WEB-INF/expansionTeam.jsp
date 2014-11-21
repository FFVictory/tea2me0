<%--
  Created by IntelliJ IDEA.
  User: Drew
  Date: 18/11/2014
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/Branch">
    <input type="submit" name="branch" value="branch">
</form>
<form action="/PotentialBranch">
    <input type="submit" name="potential branch" value="potential branch">
</form>
<form action="/GeoPolitical">
    <input type="submit" name="geo-political" value="geo-political">
</form>
<form action="/NaturalDisasters">
    <input type="submit" name="natural disasters" value="natural disasters">
</form>
<form action="/Competition" method="get">
    <input type="submit" name="competition" value="competition">
</form>
<form action="/StaffOptions">
    <input type="submit" name="staff" value="Staff">
</form>

<form action="/Logout" method="post">
    <input type="submit" value="Logout">
</form>
</body>
</html>
