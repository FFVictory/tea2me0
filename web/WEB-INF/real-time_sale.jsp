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
<%@ page import="java.util.*" %>
<%@page import="stores.Item" %>
<%@page import="stores.List" %>

<html>
<head>
    <title> Real-time Sale</title>
</head>
<body>
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
<div id="footer"><p1>TeaToMe  All rights reserved.</p1></div>

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
        java.util.LinkedList<Item> tm;
        System.out.println("6");
        tm  = (java.util.LinkedList<Item>) session.getAttribute("Items");
        List lt = new List();
        tm = lt.getItem();
        if(tm != null){
            Iterator<Item> iterator;
            iterator = tm.iterator();
            System.out.println("8");
           // if(iterator.hasNext())
               // System.out.println("9");
           // System.out.println("10");
            while (iterator.hasNext()) {
                System.out.println("9");
                Item t = (Item) iterator.next();
                System.out.println("10");
                System.out.println(t.getName());
                System.out.println(t.getPrice());


                total+=t.getPrice();

    %>

    <%=t.getName()+"                       "+t.getPrice()+"\n" %>
    <% }%>
    <br>
    <%="Total=£"+total%>
    <form  method="GET" action="rtSale" >
        <input type="submit" name="sc" value ="Sale Complete" style="width: 80px; height: 30px;">
    </form>
    <form  method="POST" action="rtSale" >
        <input type="submit" name="cli" value ="Cancel Last Item" style="width: 80px; height: 30px;">
    </form>
    <% } %>
</div>
</body>
</html>
