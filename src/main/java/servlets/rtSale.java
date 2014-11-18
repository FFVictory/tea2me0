package servlets;
import models.RTSale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import stores.Item;
import stores.List;
import java.sql.*;
import java.util.*;
import java.util.LinkedList;

/**
 * Created by Kunjia on 2014/11/6.
 */


@WebServlet(name = "rtSale", urlPatterns = {"/rtSale"})
public class rtSale extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("sc")!=null) {
            HttpSession session=request.getSession();
            List lt=new List() ;
           //
            lt=(List) session.getAttribute("list");
           // lt = (List) session.getAttribute("list");
            RTSale rt=new RTSale();
            System.out.println("11");
            try {
                System.out.println("22");
                rt.RTS(lt.getItem());
                System.out.println("33");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            RequestDispatcher rd=request.getRequestDispatcher("real-time_sale.jsp");
            rd.forward(request,response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String n=request.getParameter("t1");
        List l=new List();
        HttpSession session=request.getSession();
        if (session.getAttribute("list")!=null)
            l=(List) session.getAttribute("list");
        if(n!=null){
            Item itm= new Item();
            double prc;
            switch(n)
            {
                case "Earl Grey": prc = 2.55;
                    break;
                case "Breakfast":  prc = 2.25;
                    break;
                case "Fruit":  prc = 2.75;
                    break;
                case "Standard Green":  prc = 3.00;
                    break;
                case "Flavoured": prc = 3.10;
                    break;
                case "White":  prc = 2.25;
                    break;
                case "Yellow":  prc = 3.35;
                    break;
                case "Dark":  prc = 3.75;
                    break;
                case "Black":  prc = 3.75;
                    break;
                case "Herb":  prc = 3.35;
                    break;
                case "Oolong":  prc = 4.25;
                    break;
                case "Muffin":  prc = 4.55;
                    break;
                case "Biscuit":  prc = 1.75;
                    break;
                case "Cookie":  prc = 1.55;
                    break;
                case "West Lake":  prc = 4.20;
                    break;
                default: prc= 0;
                    break;
            }
            java.sql.Date t = new java.sql.Date(System.currentTimeMillis());
            session.setAttribute("item", itm);
            itm.setDate(t);
            itm.setPrice(prc);
            itm.setName(n);
            l.setItem(itm);
            session.setAttribute("list", l);
        }
        String cancel=request.getParameter("cli");
        if(cancel!=null){
            List i = new List();
            if (session.getAttribute("list")!=null)
                i=(List) session.getAttribute("list");
            i=(List) session.getAttribute("list");
            (i.getItem()).remove(i.getItem().getLast());
            session.setAttribute("list", i);

        }
        RequestDispatcher rd=request.getRequestDispatcher("real-time_sale.jsp");
        rd.forward(request,response);
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
