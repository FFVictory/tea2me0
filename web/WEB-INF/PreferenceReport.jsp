<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/11/20
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PreferenceReport</title>
</head>
<body>
<%
    System.out.println("come to jsp");
    int vote[];
    System.out.println("1");
    vote=(int[])session.getAttribute("prefer");
    System.out.println("2");
    int counter;
    int sum=0;
    for(counter=0; counter<12;counter++){
        sum+=vote[counter];
        System.out.println("vote"+vote[counter]);
    }
    if(sum!=0)
    {
    double percent[]=new double[12];
    for(counter=0; counter<12;counter++){
        percent[counter]=(double)100*(vote[counter]/sum);

    }
    // by order
%>
<table>
    <tr>
        <td>Earl Grey</td>
        <td>Breakfast</td>
        <td>Fruit</td>
        <td>Standard Green</td>
        <td>Flavoured</td>
        <td>White</td>
        <td>Yellow</td>
        <td>Dark</td>
        <td>Black</td>
        <td>Herb</td>
        <td>Oolong</td>
        <td>West Lake</td>
    </tr>
    <tr>
        <td><%=percent[1]%>%</td>
        <td><%=percent[2]%>%</td>
        <td><%=percent[3]%>%</td>
        <td><%=percent[4]%>%</td>
        <td><%=percent[5]%>%</td>
        <td><%=percent[6]%>%</td>
        <td><%=percent[7]%>%</td>
        <td><%=percent[8]%>%</td>
        <td><%=percent[9]%>%</td>
        <td><%=percent[10]%>%</td>
        <td><%=percent[11]%>%</td>
        <td><%=percent[12]%>%</td>

    </tr>
</table>
<%}else{%>
No Record Found!
<%}%>
</body>
</html>
