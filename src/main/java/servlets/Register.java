package servlets;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import stores.*;

/**
 *
 * @author Christopher
 */
@WebServlet(name = "Register", urlPatterns = "/Register")
public class Register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException if a servlet-specific error occurs
     * @throws java.io.IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException if a servlet-specific error occurs
     * @throws java.io.IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("Register.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException if a servlet-specific error occurs
     * @throws java.io.IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String address=request.getParameter("address");
        String password=request.getParameter("password");
        String cPassword=request.getParameter("confirmPassword");
        String fname=request.getParameter("fname");
        String sname=request.getParameter("sname");

        if(password.equals(cPassword)) {
            HttpSession session = request.getSession();
            LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
            int position = lg.getPosition();
            int branchID = lg.getBranchId();


            User us = new User();
            int staffID = us.newStaffId();

            if (position == 2) {
                if (us.RegisterStaff(address, password, fname, sname, position, branchID, staffID) == true) {
                    response.sendRedirect("/Manager");
                } else {
                    response.sendRedirect("/Register");
                }
            } else if (position == 3) {
                int managerBranch = Integer.parseInt(request.getParameter("managerBranch"));
                if (us.RegisterManager(address, password, fname, sname, position, managerBranch, staffID) == true) {
                    response.sendRedirect("/Ceo");
                } else {
                    response.sendRedirect("/Register");
                }
            }
        }else{
            response.sendRedirect("/Register");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
