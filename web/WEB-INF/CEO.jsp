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
    <form action="/Branch">
      <input type="submit" name="branch" value="branch" style="width: 300px; height: 50px;">
    </form>
    <form action="/PotentialBranch">
      <input type="submit" name="potential branch" value="potential branch"style="width: 300px; height: 50px;">
    </form>
    <form action="/GeoPolitics">
      <input type="submit" name="geo-political" value="geo-political"style="width: 300px; height: 50px;">
    </form>
    <form action="/NaturalDisasters">
      <input type="submit" name="natural disasters" value="natural disasters"style="width: 300px; height: 50px;">
    </form>
    <form action="/Competition" method="get">
      <input type="submit" name="competition" value="competition"style="width: 300px; height: 50px;">
    </form>
    <form action="/StaffOptions">
        <input type="submit" name="staff" value="Staff"style="width: 300px; height: 50px;">
    </form>
    <form action="/Certifications">
        <input type="submit" name="staff" value="Tea Certification">
    </form>
    <form action="/Logout" method="post">
        <input type="submit" value="Logout"style="width: 100px; height: 30px;">
    </form>
</body>
</html>
