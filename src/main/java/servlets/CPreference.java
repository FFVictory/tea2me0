package servlets;

import models.LCardModel;
import models.PreferenceModel;
import stores.customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by Administrator on 2014/11/20.
 */

// get parameter

@WebServlet(name = "CPreference" , urlPatterns = "/CPreference")
public class CPreference extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        HttpSession session = request.getSession();
        System.out.println("doPost @CPreference");

        String career = request.getParameter("career");
        System.out.println("Career is "+career);

       // String dob1 = request.getParameter("dob1");
       // System.out.println("DateOfBirth is "+dob1);

       // String dob2 = request.getParameter("dob2");
       // System.out.println("DateOfBirth is "+dob2);


        int [] vote;
        customer c = new customer();

        if((career!=null))//&&(dob1!=null)&&(dob2!=null))

        {
            // c.setCareer(career);
           /* try {
                java.sql.Date d1 = c.convert(dob1);
                c.setDateOfBirth1(d1);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            try {
                java.sql.Date d2 = c.convert(dob2);
                c.setDateOfBirth1(d2);
            } catch (ParseException e) {
                e.printStackTrace();
            }*/
            //session.setAttribute("Customer", c);
            LCardModel alcd = new LCardModel();
            java.util.LinkedList<Integer> id = new java.util.LinkedList<>();
            System.out.println("prepare to search all id to get a linklist");
            id = alcd.preference(career);//, c.getDateOfBirth1(), c.getDateOfBirth2());
            PreferenceModel preMdl= new PreferenceModel();
            System.out.println("get vote for every kind of tea");
            vote=preMdl.getPreferData(id);
            session.setAttribute("prefer", vote);
            System.out.println("before going to report");
            //session.setAttribute("LoyaltyCardID", id);//never used!!!!!!!!!!!!11
            // id=(java.util.LinkedList<Integer>)session.getAttribute("LoyaltyCardID");
            RequestDispatcher rd = request.getRequestDispatcher("/PreferenceReport.jsp");
            rd.forward(request, response);
        }
        else
        {
            RequestDispatcher rd = request.getRequestDispatcher("/customerpreference.jsp");
            rd.forward(request, response);
        }

    }
}
