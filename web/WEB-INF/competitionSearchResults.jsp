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
        <input type="submit" value="Logout"style="width: 100px; height: 30px;">
    </form>
</body>
</html>
