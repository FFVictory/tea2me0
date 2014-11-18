package models;
import stores.Item;

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
    private static Connection connect = null;
    private PreparedStatement preparedStatement = null;
   // private ResultSet resultSet = null;
    public RTSale(){

    }
    public void RTS(java.util.LinkedList<Item> t) throws SQLException {
        System.out.println("0");
            try {
                Iterator<Item> iterator;
                iterator = t.iterator();
                Class.forName("com.mysql.jdbc.Driver");
                connect = DriverManager
                        .getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306" + "user=14ac3u32 & password=cab123");
                System.out.println("1");
                int i=1;
                while (iterator.hasNext()) {

                    System.out.println(i++);
                    Item tm = (Item) iterator.next();
                    preparedStatement = connect.prepareStatement("insert into 14ac3d32.order values(?,?,?,?)");
                    preparedStatement.setInt(1, i);
                    preparedStatement.setDate(2, tm.getDate());
                    preparedStatement.setInt(3, (int) tm.getPrice());
                    preparedStatement.setString(4, tm.getName());

                    preparedStatement.executeUpdate();
                    System.out.println(preparedStatement.executeUpdate());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                    try {
                       // resultSet.close();
                        preparedStatement.close();
                        connect.close();
                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                }
        }


    }

