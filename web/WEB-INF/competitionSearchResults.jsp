<%@ page import="stores.Stocks" %>
<%@ page import="stores.Competition" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.Iterator" %>
<%--
  Created by IntelliJ IDEA.
  User: Drew
  Date: 19/11/2014
  Time: 04:32
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
    <th>Address</th>
    <th>CompetitionID</th>
    <th>MarketShare</th>
    <th>Name</th>
    <th>NameOfCountry</th>
    <th>Profit</th>
  </tr>
    <%
        java.util.LinkedList<Competition> competitionList = (LinkedList<Competition>)session.getAttribute("competition");
        Competition competition= null;
        if (competitionList == null){
            System.out.println("Empty Competition Attribute");
        }
        else{
            Iterator<Competition> iterator;
            iterator = competitionList.iterator();
            while (iterator.hasNext()){
                competition = iterator.next();
%>              <tr>
                  <td><%=competition.getAddress()%></td>
                  <td><%=competition.getCompetitionId()%></td>
                  <td><%=competition.getMarketShare()%></td>
                  <td><%=competition.getName()%></td>
                  <td><%=competition.getNameOfCountry()%></td>
                  <td><%=competition.getProfit()%></td>
              </tr>
<%            }
        }
    %>
    <form action="/Logout" method="post">
        <input type="submit" value="Logout">
    </form>
</body>
</html>
