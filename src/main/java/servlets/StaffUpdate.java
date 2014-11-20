package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import stores.FoundStaff;
import models.*;

/**
 * Created by Christopher on 20/11/2014.
 */

@WebServlet(name = "StaffUpdate", urlPatterns = "/StaffUpdate")
public class StaffUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address = request.getParameter("address");
        String training = request.getParameter("training");
        int managerBranch = Integer.parseInt(request.getParameter("managerBranch"));
        String fname = request.getParameter("fname");
        String sname = request.getParameter("sname");
        int staffId = Integer.parseInt(request.getParameter("staffId"));

        User us = new User();
        us.UpdateStaff(staffId, fname, sname, address, training, managerBranch);
        response.sendRedirect("/Staff");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User us = new User();
        int staffID = Integer.parseInt(request.getParameter("param1"));
        FoundStaff staff = us.getStaffMember(staffID);
        RequestDispatcher rd = request.getRequestDispatcher("staffUpdate.jsp");
        request.setAttribute("staff", staff);

        rd.forward(request, response);
    }
}
