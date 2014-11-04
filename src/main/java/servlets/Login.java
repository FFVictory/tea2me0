package servlets;


import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import stores.LoggedIn;
import models.*;


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

        String first_name=us.First_name(username);
        String last_name =us.Last_name(username);
        String staff_ID =us.Staff_ID(username);
        String BranchID =us.BranchID(username);
        String skill =us.Skill(username);
        int Pos =us.Position(username);
        

        boolean isValid=us.IsValidUser(username, password);
        HttpSession session=request.getSession();
        System.out.println("Session in servlet "+session);
        if (isValid){
            LoggedIn lg= new LoggedIn();
            lg.setLogedin();
            lg.setUsername(username);
            lg.setfirst_name(first_name);
            lg.setlast_name(last_name);
            lg.setstaff_ID(staff_ID);
            lg.setBranch(BranchID);
            lg.setSkills(skill);
            lg.setPosition(Pos);
    
            //request.setAttribute("LoggedIn", lg);
            
            session.setAttribute("LoggedIn", lg);
            System.out.println("Session in servlet "+session);
            RequestDispatcher rd=null;
            switch (Pos) {
            case 1:
            	 rd=request.getRequestDispatcher("staff.jsp");
                break;
            case 2:
            	 rd=request.getRequestDispatcher("manager.jsp");
                break;
            case 3:
            	 rd=request.getRequestDispatcher("CEO.jsp");
                break;
            case 4:
           	     rd=request.getRequestDispatcher("ET.jsp");
               break;    
            default:
            	 rd=request.getRequestDispatcher("login.jsp");   
        }
            
	    rd.forward(request,response);
	  ///////////////////////////////////right??????????????????????????????????????????????/
	  
            
        }else{
            response.sendRedirect("/instagrim/login.jsp");
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
