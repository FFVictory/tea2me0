package servlets;

import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Christopher on 21/11/2014.
 */

@WebServlet(name = "DeleteStaff", urlPatterns = "/DeleteStaff")
public class DeleteStaff extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int staffId = Integer.parseInt(request.getParameter("deleteID"));
        User us = new User();
        us.DeleteStaff(staffId);
        response.sendRedirect("/Staff");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("deleteStaff.jsp");
    }
}
