<%--
  Created by IntelliJ IDEA.
  User: Kunjia
  Date: 2014/11/5
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="models.RTSale" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.*" %>
<%@page import="stores.Item" %>
<%@page import="stores.List" %>
<%@page import="java.text.*" %>
<%@page import="stores.*" %>
<html>
<head>
    <title> Real-time Sale</title>
</head>
<body>
<%
   // LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
   // if (lg != null) {%>
<!-- I need login to pass BranchID to me.-->
<style>
    #header {
        background-color:greenyellow;
        color:black;
        text-align:center;
        padding:10px;
    }
    #nav {
        line-height:30px;
        background-color:#eeeeee;
        height:500px;
        width:1000px;
        float:left;
        padding:5px;
    }
    .nav1 {
        line-height:30px;
        background-color:#eeeeee;
        height:166px;
        width:1000px;
        float:left;
        padding:5px;
    }
    .nav11 {
        line-height:30px;
        background-color:#eeeeee;
        height:166px;
        width:185px;
        float:left;
        padding:5px;
    }
    #section {

        float:left;
        padding:10px;
    }
    #footer {
        background-color:black;
        color:white;
        clear:both;
        text-align:center;
        padding:15px;
    }
</style>
<div id="header"><h1>TeaToMe</h1></div>
<div id="footer">
    <p1>TeaToMe  All rights reserved.</p1>
</div>

<div id="nav">
    <div class="nav1">
        <div class="nav11">
            <form  method="POST" action="rtSale" >
                <input type="submit" name="t1" value ="Earl Grey" style="width: 150px; height: 100px;" >
            </form>
        </div>
        <div class="nav11">
            <form  method="POST" action="rtSale" >
                <input type="submit" name="t1" value ="Breakfast" style="width: 150px; height: 100px;" >
            </form>
        </div>
        <div class="nav11">
            <form  method="POST" action="rtSale" >
                <input type="submit" name="t1" value ="Fruit" style="width: 150px; height: 100px;">
            </form>
        </div>
        <div class="nav11">
            <form  method="POST" action="rtSale" >
                <input type="submit" name="t1" value ="Standard Green" style="width: 150px; height: 100px;">
            </form>
        </div>
        <div class="nav11">
            <form  method="POST" action="rtSale" >
                <input type="submit" name="t1" value ="Flavoured" style="width: 150px; height: 100px;">
            </form>
        </div>
    </div>
    <div class="nav1">
        <div class="nav11">
            <form  method="POST" action="rtSale" >
                <input type="submit" name="t1" value ="White" style="width: 150px; height: 100px;">
            </form>
        </div>
        <div class="nav11">
            <form  method="POST" action="rtSale" >
                <input type="submit" name="t1" value ="Yellow" style="width: 150px; height: 100px;">
            </form>
        </div>
        <div class="nav11">
            <form  method="POST" action="rtSale" >
                <input type="submit" name="t1" value ="Dark" style="width: 150px; height: 100px;">
            </form>
        </div>
        <div class="nav11">
            <form  method="POST" action="rtSale" >
                <input type="submit" name="t1" value ="Black" style="width: 150px; height: 100px;">
            </form>
        </div>
        <div class="nav11">
            <form  method="POST" action="rtSale" >
                <input type="submit" name="t1" value ="Herb" style="width: 150px; height: 100px;">
            </form>
        </div>
    </div>
    <div class="nav1">
        <div class="nav11">
            <form  method="POST" action="rtSale" >
                <input type="submit" name="t1" value ="West Lake" style="width: 150px; height: 100px;">
            </form>
        </div>
        <div class="nav11">
            <form  method="POST" action="rtSale" >
                <input type="submit" name="t1" value ="Oolong" style="width: 150px; height: 100px;">
            </form>
        </div>
        <div class="nav11">
            <form  method="POST" action="rtSale" >
                <input type="submit" name="t1" value ="Muffin" style="width: 150px; height: 100px;">
            </form>
        </div>
        <div class="nav11">
            <form  method="POST" action="rtSale" >

                <input type="submit" name="t1" value ="Biscuit" style="width: 150px; height: 100px;">
            </form>
        </div>
        <div class="nav11">
            <form  method="POST" action="rtSale" >
                <input type="submit" name="t1" value ="Cookie" style="width: 150px; height: 100px;">
            </form>
        </div>
    </div>
</div>
<div id="section">
    <%
        double total=0;
        List lt=new List();
        if (session.getAttribute("list")!=null)
            lt = (List) session.getAttribute("list");
        java.util.LinkedList<Item> tm = lt.getItem();
        if(tm != null){
            Iterator<Item> iterator;
            iterator = tm.iterator();
            while (iterator.hasNext()) {
                Item t = (Item) iterator.next();
                total+=t.getPrice();
             //   total.setPrecision(2);


    %>
    <li>
        <%=t.getName()+t.getPrice() %>
    </li>
    <% }
        DecimalFormat df = new DecimalFormat("#.##");%>
    <br>
    <%="Total=£"+df.format(total)%>
    <% System.out.println("jsp");%>
    <form  method="GET" action="rtSale" >
           LoyaltyCardID : <input type="number" name="LCid">
        <input type="submit" name="sc" value ="Sale Complete" style="width: 120px; height: 30px;">
    </form>

    <form  method="POST" action="rtSale" >
        <input type="submit" name="cli" value ="Cancel Last Item" style="width: 120px; height: 30px;">
    </form>
    <% } %>
    <button onclick="window.location='sale.jsp'">back</button>

    <form action="/Logout" method="post">
        <input type="submit" value="Logout">
    </form>
</div>
<%//}else{%>
<li><a href="index.jsp">Login</a></li>
<% //  }%>
</body>
</html>
