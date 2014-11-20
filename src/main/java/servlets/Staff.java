package servlets;

import models.StaffModel;
import stores.FoundStaff;
import stores.LoggedIn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.RequestDispatcher;

/**
 * Created by Christopher on 20/11/2014.
 */

@WebServlet(name = "Staff", urlPatterns = "/Staff")

public class Staff extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
        int position = lg.getPosition();
        int branchID = lg.getBranchId();

                    StaffModel sm = new StaffModel();
            LinkedList<FoundStaff> results = sm.getStaff(branchID, position);
            RequestDispatcher rd = request.getRequestDispatcher("/staff.jsp");
            request.setAttribute("results", results);

            rd.forward(request, response);
    }
}
