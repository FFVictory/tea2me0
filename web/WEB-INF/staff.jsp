<%--
  Created by IntelliJ IDEA.
  User: Christopher
  Date: 20/11/2014
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>

<%@page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="stores.*"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Tea2Me</title>
    <link rel="stylesheet" type="text/css" href="Styles.css" />
</head>
<body>


<article>
    <h3>Staff Members:</h3>
    <table style="width:100%">
        <tr>
            <th>Staff ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <%
                LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
                if(lg.getPosition()== 3){
            %>
            <th>Branch ID</th>
            <%
                }
            %>
            <th>Training</th>
            <th>Address</th>
        </tr>
    <%
        LinkedList<FoundStaff> fl = (LinkedList<FoundStaff>) request.getAttribute("results");
        if (fl == null) {
    %>
    <p>No Staff Found</p>
    <%
    } else {
        Iterator<FoundStaff> iterator;
        iterator = fl.iterator();
        while (iterator.hasNext()) {
            FoundStaff fi = iterator.next();

    %>

        <tr>
            <td><a href = "/StaffUpdate?param1=<%=fi.getStaffId()%>">  <%=fi.getStaffId()%> </a></td>
            <td><%=fi.getFirstName()%></td>
            <td><%=fi.getLastName()%></td>
            <%
                if(lg.getPosition()== 3){
            %>
            <td><%=fi.getBranchId()%></td>
            <%
                }
            %>
            <td><%=fi.getTraining()%></td>
            <td><%=fi.getAddress()%></td>
        </tr>
    <%

        }
    }
%>

    </table>


</article>
<footer>
    <ul>
        <li class="footer"><a href="/Tea2Me">Home</a></li>
    </ul>
</footer>
<form action="/Logout" method="post">
    <input type="submit" value="Logout">
</form>
</body>
</html>
