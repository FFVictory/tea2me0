package servlets;

import jdk.nashorn.internal.ir.RuntimeNode;
import models.LCardModel;
import stores.Loyaltycard;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * Created by KJ on 2014/11/19.
 */

@WebServlet(name = "AddLoyaltyCard" , urlPatterns = "/AddLoyaltyCard")
public class AddLoyaltyCard extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get parameter
        HttpSession session = request.getSession();
        System.out.println("doPost @AddLoyaltyCard");
        String fname = request.getParameter("fname");
        System.out.println("Firstname is " + fname);

        String lname = request.getParameter("lname");
        System.out.println("Lastname is " + lname);

        String city = request.getParameter("city");
        System.out.println("City is " + city);

        String career = request.getParameter("career");
        System.out.println("Career is " + career);

        String dob = request.getParameter("dob");
        System.out.println("DateOfBirth is " + dob);

        String gender = request.getParameter("gender");
        System.out.println("Gender is " + gender);

        String bp = request.getParameter("bp");
        System.out.println("BonusPoint is " + bp);
//set infor for LoyaltyCard
        Loyaltycard lc = new Loyaltycard();
        lc.setFname(fname);
        lc.setLname(lname);
        lc.setCity(city);
        lc.setCareer(career);

        try {
            java.sql.Date d = lc.convert(dob);
            lc.setDateOfBirth(d);////////////right?????????
        } catch (ParseException e) {
            e.printStackTrace();
        }

        lc.setGender(gender);

       //int b = Integer.parseInt(bp);
        //lc.setBonusPoint(b);

        LCardModel alcd = new LCardModel();
        int id=alcd.getLoyaltyCardID()+1;
        alcd.addLoyaltyCard(id,fname, lname, city, career, lc.getDateOfBirth(), gender);
        lc.setID(id);
        session.setAttribute("Lcard", lc);
        RequestDispatcher rd = request.getRequestDispatcher("/showloyaltycard.jsp");
        rd.forward(request, response);

    }
}