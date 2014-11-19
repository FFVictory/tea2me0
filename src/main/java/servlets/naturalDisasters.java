package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Drew on 19/11/2014.
 */
@WebServlet(name = "naturalDisasters" ,urlPatterns = "/NaturalDisasters")
public class NaturalDisasters extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("huj @naturalDisasters");
        RequestDispatcher rd = request.getRequestDispatcher("/naturalDisasters.jsp");
        rd.forward(request,response);
    }
}
