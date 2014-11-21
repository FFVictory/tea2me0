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
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Instagrim</title>
  <link rel="stylesheet" type="text/css" href="Styles.css" />
</head>
<body>
<script  src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">
  function validateMyForm()
  {
    var city = $.trim($('#city').val());
    var branchId = $.trim($('#branchIdId').val());
    if(city  === '' && branchId ==='')
    {
      alert("Empty Input");
      return false;
    }
    return true;
  }
</script>
<form action="/Search" method="get" id="form1" onsubmit="return validateMyForm()">

  <br>
  City : <input type="text" name="city" id="city"><br>
  BranchId : <input type="text" name="branchId" id="branchIdId"><br>
  <input type="submit" value="Search" id="submission">
</form>
<br>
<form action="/Logout" method="post">
  <input type="submit" value="Logout">
</form>
<br>

</body>
</html>
