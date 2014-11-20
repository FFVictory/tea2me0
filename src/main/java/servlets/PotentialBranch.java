package servlets;

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
 * Created by Drew on 20/11/2014.
 */
@WebServlet(name = "PotentialBranch", urlPatterns = "/PotentialBranch")
public class PotentialBranch extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        models.PotentialBranch pbm = new models.PotentialBranch();
        LinkedList<stores.PotentialBranch> potentialBranches = pbm.getBranches();
        session.setAttribute("potentialBranch", potentialBranches);
        RequestDispatcher rd = request.getRequestDispatcher("/potentialBranch.jsp");
        rd.forward(request, response);
        
    }
}
