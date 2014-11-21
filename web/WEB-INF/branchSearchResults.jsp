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
        <th>Lease Costs :</th>
        <th>Revenue : </th>
        <th>City ID : </th>

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
        <td><%=bs.getBranchId()%>
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
        <td><%=bs.getLeaseCost()%>
        </td>
        </td>
        <td><%=bs.getRevenue()%>
        </td>
        </td>
        <td><%=bs.getCityId()%>
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
