package servlets;

import models.BranchModel;
import models.User;
import stores.BranchStore;
import stores.FoundStaff;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Drew on 21/11/2014.
 */
@WebServlet(name = "BranchUpdate", urlPatterns = "/BranchUpdate")
public class BranchUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BranchModel bm = new BranchModel();
        int size = 0, expenditure = 0, advertismentCosts = 0, leaseCost = 0, revenue = 0, branchId = 0;
        String sizeS, expenditureS, advertismentCostsS, leaseCostS, revenueS, branchIdS;
        String address;
        sizeS = request.getParameter("size");
        address = request.getParameter("address");
        expenditureS = request.getParameter("expenditure");
        advertismentCostsS = request.getParameter("advertismentCosts");
        leaseCostS = request.getParameter("leaseCost");
        revenueS = request.getParameter("revenue");
        branchIdS = request.getParameter("branchId");
        if (sizeS.length() > 0)
            size = Integer.parseInt(sizeS);
        if (expenditureS.length() > 0)
            expenditure = Integer.parseInt(expenditureS);
        if (advertismentCostsS.length() > 0)
            advertismentCosts = Integer.parseInt(advertismentCostsS);
        if (leaseCostS.length() > 0)
            leaseCost = Integer.parseInt(leaseCostS);
        if (revenueS.length() > 0)
            revenue = Integer.parseInt(revenueS);
        if (branchIdS.length() > 0)
            branchId = Integer.parseInt(branchIdS);
        bm.UpdateBranch(branchId, size, address, expenditure, advertismentCosts, leaseCost, revenue, branchId);
        response.sendRedirect("/Branch");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BranchModel bm = new BranchModel();
        int branchId = Integer.parseInt(request.getParameter("param1"));
        LinkedList<BranchStore> bsList = new LinkedList<BranchStore>();
        bsList = bm.findBranch(0, branchId);
        RequestDispatcher rd;
        if (bsList.size() > 0) {
            BranchStore bs = bsList.getFirst();
            request.setAttribute("branch", bs);
            rd = request.getRequestDispatcher("branchUpdate.jsp");
        } else
            rd = request.getRequestDispatcher("/Branch");
        rd.forward(request, response);

    }
}
