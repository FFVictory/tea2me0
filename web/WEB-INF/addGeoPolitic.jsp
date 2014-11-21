<%--
  Created by IntelliJ IDEA.
  User: Drew
  Date: 21/11/2014
  Time: 06:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
    <title></title>
</head>
<body>
<div id="header"><h1>TeaToMe</h1></div>
<div id="footer">
    <p1>TeaToMe  All rights reserved.</p1>
</div>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">
    function validateMyForm() {
        var country = $.trim($('#country').val());
        var embargo = $.trim($('#embargo').val());
        var sanctions = $.trim($('#sanctions').val());
        var visa = $.trim($('#visa').val());
        var riot = $.trim($('#riot').val());
        if (country === '' || embargo === '' || sanctions === '' || visa === '' || riot === '') {
            alert("Please Complete All Fields");
            return false;
        }
        return true;
    }
</script>
<form action="/AddGeoPolitic" method="post" onsubmit="return validateMyForm()">
    Choose your country : <select name="country">
    <option value="UK">United Kingdom</option>
    <option value="USA">United States Of America</option>
    <option value="Finland">Finland</option>
    <option value="Russia">Russia</option>
    <option value="Netherlands">Netherlands</option>
    <option value="China">China</option>
</select> <br>
    Embargo (1-10) <input type="text" name="embargo"><br>
    Sanctions (1-10) <input type="text" name="sanctions"><br>
    Visa (1-10) <input type="text" name="visa"><br>
    Riot (1-10) <input type="text" name="riot"><br>
    <input type="submit" value="Add"style="width: 100px; height: 30px;"><br>
</form>
<form action="/Logout" method="post">
    <input type="submit" value="Logout"style="width: 100px; height: 30px;">
</form>
</body>
</html>
