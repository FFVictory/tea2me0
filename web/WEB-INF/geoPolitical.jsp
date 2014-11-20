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
</head>
<body>
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
<form action="/Logout" method="post">
  <input type="submit" value="Logout">
</form>
</body>
</html>
