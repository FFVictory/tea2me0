package servlets;

import models.BranchModel;
import stores.BranchStore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Drew on 19/11/2014.
 */
@WebServlet(name = "Search", urlPatterns = "/Search")
public class Search extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost @Search");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("doGet @Search");
        String country = request.getParameter("country");
        String branch = request.getParameter("branchId");
        String city = request.getParameter("city");
        int branchId = 0;
        int cityId = 0;
        if (branch.length() > 0) {
            branchId = Integer.parseInt(branch);
        }
        if (city.length() > 0) {
            cityId = Integer.parseInt(city);
        }
        BranchModel bm = new BranchModel();
        LinkedList<BranchStore> bs = bm.findBranch(cityId, branchId);
        session.setAttribute("branch", bs);
        RequestDispatcher rd = request.getRequestDispatcher("/branchSearchResults.jsp");
        rd.forward(request, response);

    }
}
