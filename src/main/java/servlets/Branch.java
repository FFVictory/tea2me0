package servlets;

import jdk.nashorn.internal.ir.RuntimeNode;

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
@WebServlet(name = "Branch" , urlPatterns = "/Branch")
public class Branch extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Branch.doGet");
        RequestDispatcher rd = request.getRequestDispatcher("branch.jsp");
        rd.forward(request,response);
    }
}
