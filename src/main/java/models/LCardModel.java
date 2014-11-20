package models;

import javax.servlet.http.HttpSession;
import java.sql.*;
import stores.Loyaltycard;
/**
 * Created by KJ on 2014/11/19.
 */
public class LCardModel {
    private Connection connect = null;
    private PreparedStatement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;
    public int getLoyaltyCardID() {
        Loyaltycard l=new Loyaltycard();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                    + "user=14ac3u32&password=cab123");
            preparedStatement = connect.prepareStatement("Select loyaltyCardID from 14ac3d32.loyaltycard ");
            rs=preparedStatement.executeQuery();

            rs.last();

            int i = rs.getInt("loyaltyCardID");
            l.setID(i);

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

        } catch (Exception e) {
            System.out.println("Exception at LoyalCardModel");
        }
    }
}