<%@ page import="stores.NaturalDisaster" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="stores.GeoPolitical" %>
<%--
  Created by IntelliJ IDEA.
  User: Drew
  Date: 19/11/2014
  Time: 00:00
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
    <th>Name Of Country</th>
    <th>Embargo</th>
    <th>Sanctions</th>
    <th>Visa</th>
    <th>Riot</th>
  </tr>
  <%
    java.util.LinkedList<GeoPolitical> geoPoliticalList = (LinkedList<GeoPolitical>) session.getAttribute("geoPolitical");
    GeoPolitical geoPolitical = null;
    if (geoPoliticalList == null) {
      System.out.println("Empty GeoPolitical Attribute");
    } else {
      Iterator<GeoPolitical> iterator;
      iterator = geoPoliticalList.iterator();
      while (iterator.hasNext()) {
        geoPolitical = iterator.next();
  %>
  <tr>
    <td><%=geoPolitical.getNameOfCountry()%>
    </td>
    <td><%=geoPolitical.getEmbargo()%>
    </td>
    <td><%=geoPolitical.getSanctions()%>
    </td>
    <td><%=geoPolitical.getVisa()%>
    </td>
    <td><%=geoPolitical.getRiot()%>
    </td>
  </tr>
  <% }
  }
  %>
</table>
<form action="/Logout" method="post"style="width: 100px; height: 30px;">
  <input type="submit" value="Logout">
</form>
</body>
</html>
