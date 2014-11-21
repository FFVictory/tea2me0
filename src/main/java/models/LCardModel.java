package models;

import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.LinkedList;
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

import stores.Loyaltycard;
import stores.customer;

/**
 * Created by KJ on 2014/11/19.
 */
public class LCardModel {

    private Connection connect = null;
    private PreparedStatement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;
    public int getLoyaltyCardID() {
        System.out.println("into LCardModel");
        Loyaltycard l=new Loyaltycard();
        try {
            System.out.println("try to connect");
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                    + "user=14ac3u32&password=cab123");
            System.out.println("connected");
            preparedStatement = connect.prepareStatement("Select loyaltyCardID from 14ac3d32.loyaltycard ");
            System.out.println("select");
            rs=preparedStatement.executeQuery();

            rs.last();
            if(rs.isLast())
                System.out.println("the last one result");
            int i = rs.getInt("loyaltyCardID");
            l.setID(i);
            rs.close();
            preparedStatement.close();
            connect.close();


        }catch (Exception e) {
            System.out.println("Exception at LoyalCardModelGenerateID");
        }
        return l.getID();
    }
    public void addLoyaltyCard(int id,String fname,String lname, String city, String career, Date dob, String gender) {
        try {
            System.out.println("1");
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                    + "user=14ac3u32&password=cab123");
            System.out.println("2");
            preparedStatement = connect.prepareStatement("INSERT INTO 14ac3d32.loyaltycard VALUES(?,?,?,?,?,?,?,?)");
            System.out.println("3");
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2, fname);
            preparedStatement.setString(3, lname);
            preparedStatement.setString(4, city);
            preparedStatement.setString(7, career);
            preparedStatement.setDate(6, dob);
            preparedStatement.setString(8, gender);
            preparedStatement.setInt(5, 0);
            System.out.println("4");

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connect.close();

        } catch (Exception e) {
            System.out.println("Exception at LoyalCardModel");
        }
    }
    public java.util.LinkedList<Integer> preference(String ca){//,Date d1, Date d2){

        java.util.LinkedList<Integer> ID = new java.util.LinkedList<>();
        try {

            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                    + "user=14ac3u32&password=cab123");

            preparedStatement = connect.prepareStatement("Select loyaltyCardID from 14ac3d32.loyaltycard WHERE career=? order by loyaltyCardID;");

            preparedStatement.setString(1, ca);
            //AND dateOfBirth BETWEEN ? AND ?
                //    preparedStatement.setDate(2, d1);
           // preparedStatement.setDate(3, d2);

            rs=preparedStatement.executeQuery();

            int i;
            while(!rs.isLast()){
                rs.next();
                i = rs.getInt("loyaltyCardID");
                System.out.println("i="+i);
                ID.add(i);
            }

            preparedStatement.close();
            rs.close();
            connect.close();
        } catch (Exception e) {
            System.out.println("Exception at LoyalCardModel");
        }
        return ID;
    }
}