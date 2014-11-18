package servlets;

import stores.LoggedIn;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Andrew on 07/11/2014.
 */
@WebServlet(name = "ReqStock", urlPatterns = "/ReqStock")
public class ReqStock extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher rd;
        LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
        if (lg == null) {
            rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
        StockModel sm = new StockModel();
        int teaType = Integer.parseInt(request.getParameter("teaType"));
        sm.requestStock(lg.getBranchId(), teaType);
        response.sendRedirect("/Stock");
        //rd = request.getRequestDispatcher("/Stock");
        //rd.forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

}
}