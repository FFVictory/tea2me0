<%@ page import="stores.Stocks" %>
<%--
  Created by IntelliJ IDEA.
  User: Andrew
  Date: 06/11/2014
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="servlets.Stock" %>
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
        <th>BranchId</th>
        <th>Tea Type</th>
        <th>TeaName</th>
        <th>Stock Requested</th>
    </tr>
    <%
        java.util.LinkedList<Stocks> stocks = (java.util.LinkedList<Stocks>)session.getAttribute("stocks");
        Stocks stock = null;
        if (stocks == null){
            System.out.println("Empty Stocks Attribute");
        }
        else{
            Iterator<Stocks> iterator;
            iterator = stocks.iterator();
            while (iterator.hasNext()){
                stock = iterator.next();
    %>
    <tr>
        <td><%=stock.getBranchId()%></td>
        <td><%=stock.getTeaType()%></td>
        <td><%=stock.getTeaName()%>
        </td>
        <td>
            <%if(stock.getStockRequested()==1){
            %>Pending Stock<%
        }
            else{
            %>
            <form action="/ReqStock" method="post"style="width: 100px; height: 30px;">
                <input type="submit" name="teaType" value="<%=stock.getTeaType()%>" style="width: 100px; height: 30px;">Request
            </form>
            <%
        }
        %></td>
    </tr>
      <%
            }
        }
        %>

</table>
<br>

<form action="/Logout" method="post">
    <input type="submit" value="Logout">
</form>
</body>
</html>