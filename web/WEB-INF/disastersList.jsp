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
</head>
<body>

<div id="header"><h1>TeaToMe</h1></div>
<div id="footer">
    <p1>TeaToMe  All rights reserved.</p1>
</div>
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
    <input type="submit" value="Logout"style="width: 100px; height: 30px;">
</form>
</body>
</html>
