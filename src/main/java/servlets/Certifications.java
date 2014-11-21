package servlets;

import models.Certification;

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
 * Created by Drew on 21/11/2014.
 */
@WebServlet(name = "Certifications", urlPatterns = "/Certifications")
public class Certifications extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LinkedList<stores.Certification> certList = new LinkedList<stores.Certification>();
        Certification cm = new Certification();
        certList = cm.showCertificates();
        HttpSession session = request.getSession();
        session.setAttribute("certification", certList);
        RequestDispatcher rd = request.getRequestDispatcher("/certification.jsp");
        rd.forward(request, response);
    }
}
