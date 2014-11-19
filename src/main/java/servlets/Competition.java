package servlets;

import jdk.nashorn.internal.ir.RuntimeNode;
import models.CompetitionModel;

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
@WebServlet(name = "Competition" , urlPatterns = "/Competition")
public class Competition extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("doPost @Competition");
        String country = request.getParameter("country");
        System.out.println("Country is "+ country);
        CompetitionModel cm = new CompetitionModel();
        LinkedList<stores.Competition> competitionList = cm.findCompetition(country);
        session.setAttribute("competition",competitionList);
        RequestDispatcher rd = request.getRequestDispatcher("/competitionSearchResults.jsp");
        rd.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/competition.jsp");
        rd.forward(request,response);
    }
}
