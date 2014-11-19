package models;

import stores.Stocks;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.LinkedList;

/**
 * Created by Andrew on 06/11/2014.
 */
public class StockModel {
    private Connection connect = null;
    private PreparedStatement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public java.util.LinkedList<Stocks> getStock(int branchId) {
    LinkedList<Stocks> stocks = new LinkedList<Stocks>();
    try {
        Class.forName("com.mysql.jdbc.Driver");
        connect = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                + "user=14ac3u32&password=cab123");
        statement = connect.prepareStatement("Select * from 14ac3d32.branch_tea WHERE branchId =?;");
        statement.setInt(1, branchId);
        resultSet = statement.executeQuery();
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

    public void requestStock(int branchId, int teaType) {
        try {
            int teaId = 0;
            statement = null;
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                    + "user=14ac3u32&password=cab123");
            if ((teaType != 0) && (branchId != 0)) {
                preparedStatement = null;
                preparedStatement = connect.prepareStatement("UPDATE 14ac3d32.branch_tea SET stockRequested=true WHERE branchId=? AND teaId=?;");
                preparedStatement.setInt(1, branchId);
                preparedStatement.setInt(2, teaType);
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("Exception happened at requestStock @StockModel");
        }
    }

}
