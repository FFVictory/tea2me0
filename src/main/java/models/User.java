package models;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import lib.AeSimpleSHA1;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import stores.LoggedIn;

public class User {
	  private static Connection connect = null;
	  //private Statement statement = null;
	  private PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
	//Cluster cluster;
    public User(){
        
    }

    public boolean IsValidUser(String username, String Password) {

        AeSimpleSHA1 sha1handler = new AeSimpleSHA1();
        String EncodedPassword = null;
        try {
            EncodedPassword = AeSimpleSHA1.SHA1(Password);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException et) {
            System.out.println("Can't check your password");
            return false;
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                                                +"user=14ac3u32&password=cab123");
            preparedStatement = connect.prepareStatement("select password from 14ac3d32.staffmember where staffId = ?;");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String StoredPass = resultSet.getString("password");
                if (StoredPass.compareTo(EncodedPassword) == 0) {
                    return true;
                }else {
                    return false;
                }
            }
        } catch (Exception ex) {
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
        return true;//need to correct this method

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
             Class.forName("com.mysql.jdbc.Driver");
    	        connect = DriverManager
    	                .getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                                +"user=14ac3u32&password=cab123");
    	        preparedStatement  = connect.prepareStatement("select firstName from 14ac3d32.staffmember where staffId = ?;");
    	        preparedStatement.setString(1, username);
    	        resultSet = preparedStatement.executeQuery();
    	       
    	        	while (resultSet.next()){  
    	               
    	        		Storedname = resultSet.getString("firstName");
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
         Class.forName("com.mysql.jdbc.Driver");
   	        connect = DriverManager
   	                .getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                            +"user=14ac3u32&password=cab123");
   	        preparedStatement  = connect.prepareStatement("select lastName from 14ac3d32.staffmember where staffId = ?;");
   	        preparedStatement.setString(1, username);
   	        resultSet = preparedStatement.executeQuery();
   	       
   	        	while (resultSet.next()){  ///////////////is while right?
   	               
   	        		Storedname = resultSet.getString("lastName");
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

    public int BranchID(String username)
    {
    	String Storedname = null;
   	 try{
         Class.forName("com.mysql.jdbc.Driver");
   	        connect = DriverManager
   	                .getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                            +"user=14ac3u32&password=cab123");
   	        preparedStatement  = connect.prepareStatement("select branchId from 14ac3d32.staffmember where staffId = ?;");
   	        preparedStatement.setString(1, username);
   	        resultSet = preparedStatement.executeQuery();
   	       
   	        	while (resultSet.next()){  ///////////////is while right?
   	               
   	        		Storedname = resultSet.getString("branchId");
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
        return Integer.parseInt(Storedname);
       }
    public String Skill(String username)
    {
    	String Storedname = null;
   	 try{
         Class.forName("com.mysql.jdbc.Driver");
   	        connect = DriverManager
   	                .getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                            +"user=14ac3u32&password=cab123");
   	        preparedStatement  = connect.prepareStatement("select training from 14ac3d32.staffmember where staffId = ?;");
   	        preparedStatement.setString(1, username);
   	        resultSet = preparedStatement.executeQuery();
   	       
   	        	while (resultSet.next()){  ///////////////is while right?
   	               
   	        		Storedname = resultSet.getString("training");
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
             Class.forName("com.mysql.jdbc.Driver");
      	        connect = DriverManager
      	                .getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                                +"user=14ac3u32&password=cab123");
      	        preparedStatement  = connect.prepareStatement("select position from 14ac3d32.staffmember where staffId = ?;");
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

    public boolean RegisterStaff(String address, String Password, String fname, String sname, int user){
        AeSimpleSHA1 sha1handler=  new AeSimpleSHA1();
        String EncodedPassword=null;
        try {
            EncodedPassword = AeSimpleSHA1.SHA1(Password);
        }catch (UnsupportedEncodingException | NoSuchAlgorithmException et){
            System.out.println("Can't check your password");
            return false;
        }

        try{
            Class.forName("com.mysql.jdbc.Driver");
        connect = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                +"user=14ac3u32&password=cab123");
        preparedStatement  = connect.prepareStatement("insert into staffmember (address,password,firstName,lastName,position,salary);" + " Values(?,?,?,?,?,?);");

        preparedStatement.setString(1,address);
        preparedStatement.setString(2,EncodedPassword);
        preparedStatement.setString(3,fname);
        preparedStatement.setString(4,sname);
        preparedStatement.setInt(5, 1);
        preparedStatement.setInt(6, 15000);


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

    public boolean RegisterManager(String address, String Password, String fname, String sname, int user){
        AeSimpleSHA1 sha1handler=  new AeSimpleSHA1();
        String EncodedPassword=null;
        try {
            EncodedPassword = AeSimpleSHA1.SHA1(Password);
        }catch (UnsupportedEncodingException | NoSuchAlgorithmException et){
            System.out.println("Can't check your password");
            return false;
        }

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                    +"user=14ac3u32&password=cab123");
            preparedStatement  = connect.prepareStatement("insert into staffmember (address,password,firstName,lastName,position,salary);" + " Values(?,?,?,?,?,?);");

            preparedStatement.setString(1,address);
            preparedStatement.setString(2,EncodedPassword);
            preparedStatement.setString(3,fname);
            preparedStatement.setString(4,sname);
            preparedStatement.setInt(5, 2);
            preparedStatement.setInt(6, 25000);


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
