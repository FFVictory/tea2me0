package servlets;

import models.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Drew on 21/11/2014.
 */
@WebServlet(name = "addGeoPolitic" , urlPatterns = "/AddGeoPolitic")
public class AddGeoPolitic extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       System.out.println("doGet @AddGeoPolitic");
        String country = request.getParameter("country");
        String embargo = request.getParameter("embargo");
        String sanctions = request.getParameter("sanctions");
        String visa = request.getParameter("visa");
        String riot = request.getParameter("riot");
        int embargoInt,sanctionsInt , visaInt,riotInt;
        embargoInt=Integer.parseInt(embargo);
        sanctionsInt=Integer.parseInt(sanctions);
        visaInt=Integer.parseInt(visa);
        riotInt=Integer.parseInt(riot);
        models.GeoPolitical gpm = new models.GeoPolitical();
        gpm.addGeoPolitical(country, embargoInt,sanctionsInt,visaInt,riotInt);
        response.sendRedirect("/GeoPolitical");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("addGeoPolitic.jsp");
        rd.forward(request, response);
    }
}
