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
</head>
<body>
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
</body>
</html>
