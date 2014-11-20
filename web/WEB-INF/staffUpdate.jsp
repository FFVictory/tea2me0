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
    <title></title>
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
        <input type="submit" value="Update">
    </form>
</head>
<body>
<form action="/Logout" method="post">
    <input type="submit" value="Logout">
</form>
</body>
</html>
