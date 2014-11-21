<%@ page import="stores.FoundStaff" %>
<%--
  Created by IntelliJ IDEA.
  User: Christopher
  Date: 20/11/2014
  Time: 16:07
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
            text-align: center;
        }
    </style>
    <title></title>
</head>
    <body>
    <div id="header"><h1>TeaToMe</h1></div>
    <div id="footer">
        <p1>TeaToMe  All rights reserved.</p1>
    </div>
    <form method="POST"  action="StaffUpdate">
        <ul>
            <%
                FoundStaff fs = (FoundStaff)request.getAttribute("staff");

            %>
            <lable>staffId: <%=fs.getStaffId()%></lable>
            <input type="hidden" name="staffId" value ="<%=fs.getStaffId()%>">
            <li>Forename <input type="text" name="fname" value="<%=fs.getFirstName()%>"></li>
            <li>Surname <input type="text" name="sname" value="<%=fs.getLastName()%>"></li>
            <li>Address <input type="text" name="address" value="<%=fs.getAddress()%>"></li>
            <li>Training <input type="text" name="training" value="<%=fs.getTraining()%>"></li>
            <li>Branch ID<input type="text" name="managerBranch" value="<%=fs.getBranchId()%>"></li>

        </ul>
        <br/>
        <input type="submit" value="Update"style="width: 100px; height: 30px;">
    </form>

<form action="/Logout" method="post"style="width: 100px; height: 30px;">
    <input type="submit" value="Logout" style="width: 100px; height: 30px;">
</form>
</body>
</html>
