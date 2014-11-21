package servlets;


import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

import stores.LoggedIn;
import models.*;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        User us=new User();
       // us.setCluster(cluster);

        boolean isValid=us.IsValidUser(username, password);
        HttpSession session=request.getSession();
        System.out.println("Session in servlet "+session);
        if (isValid){

            String first_name=us.First_name(username);
            String last_name =us.Last_name(username);
            int BranchID = us.BranchID(username);
            String skill =us.Skill(username);
            int Pos =us.Position(username);

            LoggedIn lg= new LoggedIn();
            lg.setLogedin();
            lg.setfirst_name(first_name);
            lg.setlast_name(last_name);
            lg.setstaff_ID(username);
            lg.setBranchId(BranchID);
            lg.setSkills(skill);
            lg.setPosition(Pos);
    
            //request.setAttribute("LoggedIn", lg);
            
            session.setAttribute("LoggedIn", lg);
            System.out.println("Session in servlet "+session);
            RequestDispatcher rd=null;
            switch (Pos) {
            case 1:
                response.sendRedirect("/rtSale");
                break;
            case 2:
                response.sendRedirect("/Manager");
                break;
            case 3:
                response.sendRedirect("/CEO");
                break;
            case 4:
                response.sendRedirect("/ET");
               break;    
            default:
                response.sendRedirect("/Index");
        }
            
	  ///////////////////////////////////right??????????????????????????????????????????????/
	  
            
        }else{
            response.sendRedirect("/Index");
        }
        
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
