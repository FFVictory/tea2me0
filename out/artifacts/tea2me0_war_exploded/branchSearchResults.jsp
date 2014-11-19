<%--
  Created by IntelliJ IDEA.
  User: Drew
  Date: 19/11/2014
  Time: 02:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="stores.BranchStore" %>
<html>
<head>
    <title></title>
</head>
<body>
<td>
        <%
  BranchStore bs;
  bs = (BranchStore) request.getAttribute("branch");

%>
    Branch ID : <%=bs.getBranchId()%> <br>
    Size : <%=bs.getSize()%> <br>
    Address : <%=bs.getAddress()%> <br>
    Expenditure : <%=bs.getExpenditure()%> <br>
    Advertisment Costs : <%=bs.getAdvertismentCosts()%> <br>
    Lease Costs : <%=bs.getLeaseCost()%> <br>
    Revenue : <%=bs.getRevenue()%> <br>
    City ID : <%=bs.getCityId()%><br>
</body>
</html>
