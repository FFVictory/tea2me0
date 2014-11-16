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
    private ResultSet resultSet = null;

    public void RTS(java.util.LinkedList<Item> t) throws SQLException {
            try {

                Iterator<Item> iterator;
                iterator = t.iterator();

                while (iterator.hasNext()) {

                    Item tm = (Item) iterator.next();
                    connect = DriverManager
                            .getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306" + "user=14ac3u32 & password=cab123");
                    preparedStatement = connect.prepareStatement("insert into 14ac3d32.order values(?,?,?,?)");
                    preparedStatement.setInt(1, 1234);/////////////???????????????
                    preparedStatement.setDate(2, tm.getDate());
                    preparedStatement.setDouble(3, tm.getPrice());
                    preparedStatement.setString(4, tm.getName());

                    preparedStatement.executeUpdate();
                }
            }catch (SQLException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        resultSet.close();
                        preparedStatement.close();
                        connect.close();
                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                }
        }


    }

