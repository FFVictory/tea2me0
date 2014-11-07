package models;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import lib.AeSimpleSHA1;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class User {
	  private static Connection connect = null;
	  //private Statement statement = null;
	  private PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
	//Cluster cluster;
    public User(){
        
    }

    public boolean IsValidUser(String username, String Password){

        AeSimpleSHA1 sha1handler=  new AeSimpleSHA1();
        String EncodedPassword=null;
        try {
            EncodedPassword= sha1handler.SHA1(Password);
        }catch (UnsupportedEncodingException | NoSuchAlgorithmException et){
            System.out.println("Can't check your password");
            return false;
        }
        try{
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/feedback?"
                    + "user=sqluser&password=sqluserpw");///////////////////////what's this?
        preparedStatement  = connect.prepareStatement("select password from userprofiles where login =?");
        preparedStatement.setString(1, username);
        resultSet = preparedStatement.executeQuery();
       
        	while (resultSet.next()){  
               
                String StoredPass = resultSet.getString("password");
                if (StoredPass.compareTo(EncodedPassword) == 0)
                    return true;
            }
        }catch (Exception ex) {
            System.out.println(ex);
        } finally {
            try {
            	resultSet.close();
            	preparedStatement.close();
                connect.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
       return true; // THIS LINE IS FILLER CRAP
    }
        
    
    
  /*  public ResultSet readDataBase(String query) throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/feedback?"
                            + "user=sqluser&password=sqluserpw");
           // preparedStatement  = connect.prepareStatement(query);
            
            //resultSet = preparedStatement.executeQuery(query);
            
            //return resultSet;
            
          statement = connect.createStatement();
          return statement.executeQuery(query);

        } catch (Exception e) {
            throw e;
        } finally {
        	resultSet.close();
        	preparedStatement.close();
            connect.close();
        }

    }*/
    

 
    public String First_name(String username)
    {
    	String Storedname = null;
    	 try{
    	        connect = DriverManager
    	                .getConnection("jdbc:mysql://localhost/feedback?"
    	                    + "user=sqluser&password=sqluserpw");
    	        preparedStatement  = connect.prepareStatement("select first_name from userprofiles where login =?");
    	        preparedStatement.setString(1, username);
    	        resultSet = preparedStatement.executeQuery();
    	       
    	        	while (resultSet.next()){  
    	               
    	        		Storedname = resultSet.getString("first_name");
    	            }
    	        	
    	        }catch (Exception ex) {
    	            System.out.println(ex);
    	        }finally {
            try {
            	resultSet.close();
            	preparedStatement.close();
                connect.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    	 return Storedname;
    }
    
    public String Last_name(String username)
    {
    	String Storedname = null;
   	 try{
   	        connect = DriverManager
   	                .getConnection("jdbc:mysql://localhost/feedback?"
   	                    + "user=sqluser&password=sqluserpw");///////////////////////what's this?
   	        preparedStatement  = connect.prepareStatement("select last_name from userprofiles where login =?");
   	        preparedStatement.setString(1, username);
   	        resultSet = preparedStatement.executeQuery();
   	       
   	        	while (resultSet.next()){  ///////////////is while right?
   	               
   	        		Storedname = resultSet.getString("last_name");
   	            }
   	        	
   	        }catch (Exception ex) {
   	            System.out.println(ex);
   	        }finally {
   	            try {
   	            	resultSet.close();
   	            	preparedStatement.close();
   	                connect.close();
   	            } catch (SQLException e) {
   	                System.out.println(e);
   	            }
   	        }
   	return Storedname;
       }
    public String Staff_ID(String username)
    {
    	String Storedname = null;
   	 try{
   	        connect = DriverManager
   	                .getConnection("jdbc:mysql://localhost/feedback?"
   	                    + "user=sqluser&password=sqluserpw");///////////////////////what's this?
   	        preparedStatement  = connect.prepareStatement("select staff_ID from userprofiles where login =?");
   	        preparedStatement.setString(1, username);
   	        resultSet = preparedStatement.executeQuery();
   	       
   	        	while (resultSet.next()){  ///////////////is while right?
   	               
   	        		Storedname = resultSet.getString("staff_ID");
   	            }
   	        	
   	        }catch (Exception ex) {
   	            System.out.println(ex);
   	        }finally {
   	            try {
   	            	resultSet.close();
   	            	preparedStatement.close();
   	                connect.close();
   	            } catch (SQLException e) {
   	                System.out.println(e);
   	            }
   	        }
   	return Storedname;
       }
    public String BranchID(String username)
    {
    	String Storedname = null;
   	 try{
   	        connect = DriverManager
   	                .getConnection("jdbc:mysql://localhost/feedback?"
   	                    + "user=sqluser&password=sqluserpw");///////////////////////what's this?
   	        preparedStatement  = connect.prepareStatement("select BranchID from userprofiles where login =?");
   	        preparedStatement.setString(1, username);
   	        resultSet = preparedStatement.executeQuery();
   	       
   	        	while (resultSet.next()){  ///////////////is while right?
   	               
   	        		Storedname = resultSet.getString("BranchID");
   	            }
   	        	
   	        }catch (Exception ex) {
   	            System.out.println(ex);
   	        }finally {
   	            try {
   	            	resultSet.close();
   	            	preparedStatement.close();
   	                connect.close();
   	            } catch (SQLException e) {
   	                System.out.println(e);
   	            }
   	        }
   	return Storedname;
       }
    public String Skill(String username)
    {
    	String Storedname = null;
   	 try{
   	        connect = DriverManager
   	                .getConnection("jdbc:mysql://localhost/feedback?"
   	                    + "user=sqluser&password=sqluserpw");///////////////////////what's this?
   	        preparedStatement  = connect.prepareStatement("select skills from userprofiles where login =?");
   	        preparedStatement.setString(1, username);
   	        resultSet = preparedStatement.executeQuery();
   	       
   	        	while (resultSet.next()){  ///////////////is while right?
   	               
   	        		Storedname = resultSet.getString("skills");
   	            }
   	        	
   	        }catch (Exception ex) {
   	            System.out.println(ex);
   	        }finally {
   	            try {
   	            	resultSet.close();
   	            	preparedStatement.close();
   	                connect.close();
   	            } catch (SQLException e) {
   	                System.out.println(e);
   	            }
   	        }
	return Storedname;
   	
       }
    public int Position(String username)
    {
    	 int Storedpos=0;
      	 try{
      	        connect = DriverManager
      	                .getConnection("jdbc:mysql://localhost/feedback?"
      	                    + "user=sqluser&password=sqluserpw");///////////////////////what's this?
      	        preparedStatement  = connect.prepareStatement("select position from userprofiles where login =?");
      	        preparedStatement.setString(1, username);
      	        resultSet = preparedStatement.executeQuery();
      	       
      	        	while (resultSet.next()){  ///////////////is while right?
      	               
      	        		Storedpos = resultSet.getInt("position");
      	            }
      	        
      	        }catch (Exception ex) {
      	            System.out.println(ex);
      	        }finally {
      	            try {
      	            	resultSet.close();
      	            	preparedStatement.close();
      	                connect.close();
      	            } catch (SQLException e) {
      	                System.out.println(e);
      	            }
      	        }
		return Storedpos;
      	
          }

    public boolean RegisterUser(String address, String Password, String fname, String sname){
        AeSimpleSHA1 sha1handler=  new AeSimpleSHA1();
        String EncodedPassword=null;
        try {
            EncodedPassword= sha1handler.SHA1(Password);
        }catch (UnsupportedEncodingException | NoSuchAlgorithmException et){ //????????
            System.out.println("Can't check your password");
            return false;
        }

        try{
        connect = DriverManager.getConnection("jdbc:mysql://(???url???)" + "user=sqluser & password=sqluserpw");
        preparedStatement  = connect.prepareStatement("insert into staffmember (address,password,first_name,last_name,postion)" + " Values(?,?,?,?,?)");

        preparedStatement.setString(1,address);
        preparedStatement.setString(2,EncodedPassword);
        preparedStatement.setString(3,fname);
        preparedStatement.setString(4,sname);
        preparedStatement.setInt(5, 1);


        resultSet = preparedStatement.executeQuery();

        }catch (Exception ex) {
            System.out.println(ex);
        }finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connect.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
    }
        return true;
    }
    
}
