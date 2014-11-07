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
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>

<table>
    <tr>
        <th>BranchId</th>
        <th>Stock Level</th>
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
                stock = (Stocks) iterator.next();
    %>
    <tr>
        <td><%=stock.getBranchId()%></td>
        <td><%=stock.getTeaType()%></td>
        <td><%=stock.getStock()%></td>
        <td>
            <%if(stock.getStockRequested()==1){
            %>Pending Stock<%
        }
            else{
            %>
            <form action="/Stock"  method="post">
            <button type="submit"onclick="alert('Hello world!')" value="">Request Stock!</button>
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

</body>
</html>