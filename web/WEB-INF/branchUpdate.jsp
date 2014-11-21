<%@ page import="stores.BranchStore" %>
<%--
  Created by IntelliJ IDEA.
  User: Drew
  Date: 21/11/2014
  Time: 08:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">
    function validateMyForm() {
        var size = $.trim($('#sizeI').val());
        var address = $.trim($('#addressI').val());
        var expenditure = $.trim($('#expenditureI').val());
        var advertismentCosts = $.trim($('#advertismentCostsI').val());
        var leaseCost = $.trim($('#leaseCostI').val());
        var revenue = $.trim($('#revenueI').val());
        var cityId = $.trim($('#cityIdI').val());
        if (size === '' || address === '' || expenditure === '' || advertismentCosts === '' || leaseCost === '' || revenue === '' || cityId === '') {
            alert("Please Complete All Fields");
            return false;
        }
        return true;
    }
</script>
<form method="POST" action="BranchUpdate" onsubmit="return validateMyForm()">
    <ul>
        <%
            BranchStore bs = (BranchStore) request.getAttribute("branch");

        %>
        <lable>BranchId : <%=bs.getBranchId()%>
        </lable>
        <input type="hidden" id="branchIdI" name="branchId" value="<%=bs.getBranchId()%>">
        <li>Size <input type="text" id="sizeI" name="size" value="<%=bs.getSize()%>"></li>
        <li>Address <input type="text" id="addressI" name="address" value="<%=bs.getAddress()%>"></li>
        <li>Expenditure <input type="text" id="expenditureI" name="expenditure" value="<%=bs.getExpenditure()%>"></li>
        <li>Advertisment Costs: <input type="text" name="advertismentCosts" id="advertismentCostsI"
                                       value="<%=bs.getAdvertismentCosts()%>"></li>
        <li>Lease Cost : <input type="text" id="leaseCostI" name="leaseCost" value="<%=bs.getLeaseCost()%>"></li>
        <li>Revenue : <input type="text" id="revenueI" name="revenue" value="<%=bs.getRevenue()%>"></li>
        <li>City Id : <input type="text" id="cityIdI" name="cityId" value="<%=bs.getCityId()%>"></li>

    </ul>
    <br/>
    <input type="submit" value="Update">
</form>
</body>
</html>
