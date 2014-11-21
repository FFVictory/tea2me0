<%--
  Created by IntelliJ IDEA.
  User: Christopher
  Date: 21/11/2014
  Time: 14:58
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
    <body>
<div id="header"><h1>TeaToMe</h1></div>
<div id="footer">
    <p1>TeaToMe  All rights reserved.</p1>
</div>
        <h1>Delete Staff Member:</h1>
        <form method="POST" action="DeleteStaff">
            <ul>
                <li>Staff ID to Delete: <input type="text" name="deleteID"></li>
            </ul>
            <br/>
            <input type="submit" value="Delete Member"style="width: 100px; height: 30px;">
        </form>



</body>
</html>
