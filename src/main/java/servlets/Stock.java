package servlets;

import jdk.nashorn.internal.ir.RuntimeNode;
import stores.LoggedIn;
import stores.Stocks;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Andrew on 06/11/2014.
 */
@WebServlet(urlPatterns = {
        "/Stock"
})
public class Stock extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        LoggedIn lg = ((LoggedIn) session.getAttribute("LoggedIn"));
        if (lg != null) {
            System.out.println("Logged in Stock user");
            StockModel sm = new StockModel();
            LinkedList<Stocks> stocks = sm.getStock(lg.getBranchId());
            session.setAttribute("stocks", stocks);
            RequestDispatcher rd = request.getRequestDispatcher("stock.jsp");
            rd.forward(request, response);
        } else {
            System.out.println("No attribute LoggedIn in session @Stock");
            RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
            rd.forward(request, response);
        }
    }
}
