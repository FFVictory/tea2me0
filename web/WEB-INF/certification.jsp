<%@ page import="stores.Certification" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.Iterator" %>
<%--
  Created by IntelliJ IDEA.
  User: Drew
  Date: 21/11/2014
  Time: 15:28
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
        <th>Tea Name</th>
        <th>Sale Price</th>
        <th>Buy Price</th>
        <th>Type Of Tea</th>
        <th>Tea ID</th>
        <th>UK</th>
        <th>USA</th>
        <th>Finland</th>
        <th>Russia</th>
        <th>Germany</th>
        <th>Netherlands</th>
        <th>China</th>
    </tr>
    <%
        java.util.LinkedList<Certification> certList = (LinkedList<Certification>) session.getAttribute("certification");
        Certification certification = null;
        if (certList == null) {
            System.out.println("Empty GeoPolitical Attribute");
        } else {
            Iterator<Certification> iterator;
            iterator = certList.iterator();
            while (iterator.hasNext()) {
                certification = iterator.next();
    %>
    <tr>
        <td><%=certification.getTeaName()%>
        </td>
        <td><%=certification.getSalePrice()%>
        </td>
        <td><%=certification.getBuyPrice()%>
        </td>
        <td><%=certification.getTypeOfTea()%>
        </td>
        <td><%=certification.getTeaId()%>
        </td>
        <td><%=certification.isUk()%>
        </td>
        <td><%=certification.isUsa()%>
        </td>
        <td><%=certification.isFinland()%>
        </td>
        <td><%=certification.isRussia()%>
        </td>
        <td><%=certification.isGermany()%>
        </td>
        <td><%=certification.isNetherlands()%>
        </td>
        <td><%=certification.isChina()%>
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
