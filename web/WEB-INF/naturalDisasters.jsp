<%--
  Created by IntelliJ IDEA.
  User: Drew
  Date: 19/11/2014
  Time: 00:00
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
            text-align: center;
        }
    </style>
</head>
<body>
<div id="header"><h1>TeaToMe</h1></div>
<div id="footer">
    <p1>TeaToMe  All rights reserved.</p1>
</div>
<form action="/NaturalDisasters" method="post">
  Choose your country : <select name="country">
  <option value="UK">United Kingdom</option>
  <option value="USA">United States Of America</option>
  <option value="Finland">Finland</option>
  <option value="Russia">Russia</option>
  <option value="Netherlands">Netherlands</option>
  <option value="China">China</option>
</select> <br><br><br>
  <input type="submit" value="Search"style="width: 100px; height: 30px;">
</form>
<form action="/Logout" method="post">
  <input type="submit" value="Logout"style="width: 100px; height: 30px;">
</form>
</body>
</html>
