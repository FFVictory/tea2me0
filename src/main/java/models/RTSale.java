package models;
import stores.*;

import java.sql.*;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import stores.Item;
import java.util.*;
/**
 * Created by Kunjia on 2014/11/6.
 */

public class RTSale {
    private Connection connect = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    public RTSale(){

    }
    public int RTS(java.util.LinkedList<Item> t, int cardid,int orderid) throws SQLException {
        System.out.println("0");
                ID cid=new ID();
            try {
                customer c = new customer();
                //c=(customer) session.getAttribute("ctm");
                System.out.println("M1");
                Iterator<Item> iterator;
                iterator = t.iterator();
                System.out.println("M2");
                Class.forName("com.mysql.jdbc.Driver");
                connect = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                        + "user=14ac3u32&password=cab123");
                System.out.println("M3");

                System.out.println("connecting...");
                while (iterator.hasNext()) {
                    System.out.println("goto loop");
                    Item tm = (Item) iterator.next();
                   preparedStatement = connect.prepareStatement("insert into 14ac3d32.order values(?,?,?,?,?)");
                    preparedStatement.setInt(1, orderid);
                    preparedStatement.setDate(2, tm.getDate());
                    preparedStatement.setDouble(3, tm.getPrice());
                    preparedStatement.setString(4, tm.getName());
                    preparedStatement.setInt(5, cardid);
                    preparedStatement.executeUpdate();
                  /*  preparedStatement = connect.prepareStatement("select bonusPoints from 14ac3d32.loyaltycard where loyaltyCardID=?");
                    preparedStatement.setInt(1, cardid);
                    int bp=resultSet.getInt("bonusPoints");
                    System.out.println("bonusPoint"+bp);
                    int newbp=bp+(int)tm.getPrice()*100;
                    System.out.println("newBonusPoint"+newbp);
                    preparedStatement.executeUpdate();
                    preparedStatement = connect.prepareStatement("UPDATE 14ac3d32.loyaltycard SET bonusPoints=?  WHERE loyaltyCardID=?;");
                    preparedStatement.setInt(1, newbp);
                    preparedStatement.setInt(2, cardid);
                    preparedStatement.executeUpdate();*/
                    orderid++;
                    System.out.println(orderid);
                    cid.setID(orderid);
                    System.out.println("succeed!");

                }
                resultSet.close();
                preparedStatement.close();
                connect.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Exception in RTSaleModel");
            }// finally {
                   // try {
                       //
                   // } catch (SQLException e) {
                       // System.out.println(e);
                    //}
               // }
        return cid.getID();
        }
    public void BPoint(java.util.LinkedList<Item> t,int cardid) throws SQLException {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                    + "user=14ac3u32&password=cab123");
            Iterator<Item> iterator;
            iterator = t.iterator();
            while (iterator.hasNext()) {
                System.out.println("Start updating bonuspoint");
                Item tm = (Item) iterator.next();
                    preparedStatement = connect.prepareStatement("select bonusPoints from 14ac3d32.loyaltycard where loyaltyCardID=?");
                    System.out.println("A");
                    preparedStatement.setInt(1, cardid);
                    System.out.println("B");
                resultSet=preparedStatement.executeQuery();
                System.out.println("C");
                    int bp=resultSet.getInt("bonusPoints");
                    System.out.println("bonusPoint"+bp);
                    int newbp=bp+(int)tm.getPrice()*100;
                    System.out.println("newBonusPoint"+newbp);
                    preparedStatement.executeUpdate();
                    preparedStatement = connect.prepareStatement("UPDATE 14ac3d32.loyaltycard SET bonusPoints=?  WHERE loyaltyCardID=?;");
                    preparedStatement.setInt(1, newbp);
                    preparedStatement.setInt(2, cardid);
                    preparedStatement.executeUpdate();

                System.out.println("succeed in updating");

            }
            resultSet.close();
            preparedStatement.close();
            connect.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception in RTSaleModel");
        }// finally {
        // try {
        //
        // } catch (SQLException e) {
        // System.out.println(e);
        //}
        // }

    }
    public int getOrderID() {
        ID id = new ID();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                    + "user=14ac3u32&password=cab123");
            preparedStatement = connect.prepareStatement("Select orderId from 14ac3d32.order order by orderId ");
            resultSet=preparedStatement.executeQuery();

            resultSet.last();
            int i = resultSet.getInt("orderId");
            id.setID(i);
            System.out.println("RTSale1   "+id.getID());
            resultSet.close();
            preparedStatement.close();
            connect.close();


        }catch (Exception e) {
            System.out.println("Exception at LoyalCardModelGenerateID");
        }
        System.out.println("RTSale2   "+id.getID());
        return id.getID();
    }
    }




/*#define n 12
* public int[] vote(String i){
*
*   int num[n]={0};
*    switch(1)
            {
                case "Earl Grey": num[1]++;
                    break;
                case "Breakfast":  num[2]++;
                    break;
                case "Fruit":  num[3]++;
                    break;
                case "Standard Green":  num[4]++;
                    break;
                case "Flavoured": num[5]++;
                    break;
                case "White":  num[6]++;
                    break;
                case "Yellow":  num[7]++;
                    break;
                case "Dark":  num[8]++;
                    break;
                case "Black":  num[9]++;
                    break;
                case "Herb":  num[10]++;
                    break;
                case "Oolong":  num[11]++;
                    break;
                case "West Lake":  num[12]++;
                    break;
                default: num[0]++;
                    break;
            }
        return num[];
* }
* */
