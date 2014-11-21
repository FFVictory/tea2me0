<%@ page import="stores.PotentialBranch" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.Iterator" %>
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
<table>
  <tr>
    <th>Branch ID</th>
    <th>Lease Cost</th>
    <th>Projected Profit</th>
    <th>Projected Expenditure</th>
    <th>City ID</th>
    <th>Country</th>
  </tr>
  <%
    java.util.LinkedList<PotentialBranch> potentialBranchList = (LinkedList<PotentialBranch>) session.getAttribute("potentialBranch");
    PotentialBranch potentialBranch = null;
    if (potentialBranchList == null) {
      System.out.println("Empty potentialBranch Attribute @jsp");
    } else {
      Iterator<PotentialBranch> iterator;
      iterator = potentialBranchList.iterator();
      while (iterator.hasNext()) {
        potentialBranch = iterator.next();
  %>
  <tr>
    <td><%=potentialBranch.getBranchId()%>
    </td>
    <td><%=potentialBranch.getLeaseCost()%>
    </td>
    <td><%=potentialBranch.getProjectedProfit()%>
    </td>
    <td><%=potentialBranch.getProjectedExpenditure()%>
    </td>
    <td><%=potentialBranch.getCountry()%>
    </td>
  </tr>
  <% }
  }
  %>
</table>
<form action="/Logout" method="post">
  <input type="submit" value="Logout"style="width: 100px; height: 30px;">
</form>
</body>
</html>
