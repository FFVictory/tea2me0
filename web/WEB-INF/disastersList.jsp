<%@ page import="stores.Competition" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="stores.NaturalDisaster" %>
<%--
  Created by IntelliJ IDEA.
  User: Drew
  Date: 19/11/2014
  Time: 22:28
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
        <th>Tornado</th>
        <th>Tsunami</th>
        <th>Volcano Eruptions</th>
        <th>Flood</th>
    </tr>
        <%
        java.util.LinkedList<NaturalDisaster> disasterList = (LinkedList<NaturalDisaster>)session.getAttribute("naturalDisaster");
        NaturalDisaster disaster= null;
        if (disasterList == null){
            System.out.println("Empty Disasters Attribute");
        }
        else{
            Iterator<NaturalDisaster> iterator;
            iterator = disasterList.iterator();
            while (iterator.hasNext()){
                disaster = iterator.next();
%>
    <tr>
        <td><%=disaster.getNameOfCountry()%>
        </td>
        <td><%=disaster.getTornado()%>
        </td>
        <td><%=disaster.getTsunami()%>
        </td>
        <td><%=disaster.getVolcanoEruptions()%>
        </td>
        <td><%=disaster.getFlood()%>
        </td>
    </tr>
        <%            }
        }
    %>
</table>
<form action="/Logout" method="post">
    <input type="submit" value="Logout">
</form>
</body>
</html>
