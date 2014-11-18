package servlets;
import models.RTSale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import stores.Item;
import java.sql.*;
import java.util.LinkedList;

/**
 * Created by Kunjia on 2014/11/6.
 */


//@WebServlet(name = "rtSale", urlPatterns = {"/rtSale"})
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
       System.out.print("Get method of rTsale happening");
        if(request.getParameter("cs")!=null) {
            HttpSession session=request.getSession();
            java.util.LinkedList<Item> tm ;
            tm = (java.util.LinkedList<Item>) session.getAttribute("Items");
        RTSale rt=new RTSale();
        try {
            rt.RTS(tm);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String n=request.getParameter("t1");
       System.out.print("Post method of rTsale happening");
        java.util.LinkedList<Item> item;
        item = new java.util.LinkedList<>();
        Item itm= new Item();
        if(n!=null){
       int i = Integer.parseInt(n);
        double prc;
         switch(i)
        {
            case 827: prc = 2.55;
                break;
            case 2:  prc = 2.25;
                break;
            case 3:  prc = 2.75;
                break;
            case 4:  prc = 3.00;
                break;
            case 5: prc = 3.10;
                break;
            case 6:  prc = 2.25;
                break;
            case 7:  prc = 3.35;
                break;
            case 8:  prc = 3.75;
                break;
            case 9:  prc = 3.75;
                break;
            case 10:  prc = 3.35;
                break;
            case 11:  prc = 4.25;
                break;
            case 12:  prc = 4.55;
                break;
            case 13:  prc = 1.75;
                break;
            case 14:  prc = 1.55;
                break;
            case 15:  prc = 1.20;
                break;
            default: prc= 0;
                break;
        }


        Date t = new java.sql.Date(System.currentTimeMillis());
        itm.setDate(t);
        itm.setPrice(prc);
        itm.setName(n);
        item.add(itm);
        }
        String cancel=request.getParameter("cli");
        if(cancel!=null){
          item.remove(item);
        }

        HttpSession session=request.getSession();
        session.setAttribute("Items", item);




       // session.setAttribute("price", prc);

          RequestDispatcher rd=request.getRequestDispatcher("rtSale.jsp");
           rd.forward(request,response);
           // response.sendRedirect("rtSale.jsp");
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
