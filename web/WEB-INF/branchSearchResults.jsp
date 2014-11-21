<%--
  Created by IntelliJ IDEA.
  User: Drew
  Date: 19/11/2014
  Time: 02:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="stores.BranchStore" %>
<%@ page import="servlets.Branch" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.Iterator" %>
<html>
<head>
    <title></title>
</head>
<body>

<table>
    <tr>
        <th>Branch ID :</th>
        <th>Size :</th>
        <th>Address : </th>
        <th>Expenditure : </th>
        <th>Advertisment Costs :</th>
        <th>Revenue : </th>
        <th>City ID : </th>
        <th>Lease Costs :</th>
        <th>Name :</th>
        <th>Tea Quality :</th>
        <th>Credit Rating :</th>

    </tr>
    <%
        LinkedList<BranchStore> branchStoreList = (LinkedList<BranchStore>)session.getAttribute("branch");
        BranchStore bs = null;
        if (branchStoreList == null){
            System.out.println("Empty Disasters Attribute");
        }
        else{
            Iterator<BranchStore> iterator;
            iterator = branchStoreList.iterator();
            while (iterator.hasNext()){
                bs = iterator.next();
    %>
    <tr>
        <td><a href="/BranchUpdate?param1=<%=bs.getBranchId()%>"><%=bs.getBranchId()%>
        </a>
        </td>
        <td><%=bs.getSize()%>
        </td>
        <td><%=bs.getAddress()%>
        </td>
        <td><%=bs.getExpenditure()%>
        </td>
        <td><%=bs.getAdvertismentCosts()%>
        </td>
        </td>
        <td><%=bs.getRevenue()%>
        </td>
        <td><%=bs.getCityId()%>
        </td>
        <td><%=bs.getLeaseCost()%>
        </td>
        <td><%=bs.getSupplierName()%>
        </td>
        <td><%=bs.getTeaQuality()%>
        </td>
        <td><%=bs.getcRating()%>
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
