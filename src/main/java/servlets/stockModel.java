package servlets;

import stores.Stocks;

import java.sql.*;
import java.util.LinkedList;

/**
 * Created by Andrew on 06/11/2014.
 */
public class StockModel {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

public java.util.LinkedList<Stocks> getStock(){
    LinkedList<Stocks> stocks = new LinkedList<Stocks>();
    try {
        Class.forName("com.mysql.jdbc.Driver");
        connect = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                + "user=14ac3u32&password=cab123");
        statement=connect.createStatement();
        resultSet = statement.executeQuery("Select * from 14ac3d32.branch_tea;");
        if (resultSet != null) {
            while (resultSet.next()) {
                Stocks stock = new Stocks();
                stock.setBranchId(resultSet.getInt("branchId"));
                stock.setStock(resultSet.getInt("stockLevel"));
                stock.setTeaType(resultSet.getInt("teaId"));
                stock.setStockRequested(resultSet.getInt("stockRequested"));
                stocks.add(stock);
            }
        } else {
            System.out.println("SQL did not return any stock from DB\n");
        }
    }
    catch(Exception e)
    {
        System.out.println("Exception happened in StockModel");
    }
        return stocks;

}

}
