package servlets;

import models.DisastersModel;
import stores.NaturalDisaster;

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
 * Created by Drew on 19/11/2014.
 */
@WebServlet(name = "naturalDisasters" ,urlPatterns = "/NaturalDisasters")
public class NaturalDisasters extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("doPost @naturalDisasters");
        DisastersModel dm = new DisastersModel();
        LinkedList<NaturalDisaster> naturalDisaster = dm.getDisasters(request.getParameter("country"));
        if (naturalDisaster.size() == 0) System.out.println("Whoops , natural disasters is empty at servlet");
        session.setAttribute("naturalDisaster", naturalDisaster);
        RequestDispatcher rd = request.getRequestDispatcher("/disastersList.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet @naturalDisasters");

        RequestDispatcher rd = request.getRequestDispatcher("/naturalDisasters.jsp");
        rd.forward(request,response);
    }
}
