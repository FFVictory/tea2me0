package servlets;

import stores.Stocks;

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
 * Created by Andrew on 06/11/2014.
 */
@WebServlet(urlPatterns = {
        "/Stock"
})
public class Stock extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Stock progressing");
        StockModel sm = new StockModel();
        LinkedList<Stocks> stocks= sm.getStock();
        HttpSession session = request.getSession();
        session.setAttribute("stocks",stocks);
        RequestDispatcher rd = request.getRequestDispatcher("stock.jsp");
        rd.forward(request,response );

    }
}
