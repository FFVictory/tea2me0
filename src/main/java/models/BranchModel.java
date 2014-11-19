package models;

import stores.BranchStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Drew on 19/11/2014.
 */
public class BranchModel {
    private PreparedStatement ps = null;
    private Connection connect = null;
    private ResultSet rs = null;

    public BranchStore findBranch(int cityId, int branchId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                    + "user=14ac3u32&password=cab123");
        } catch (Exception e) {
            System.out.println("Error with DB connection @BranchModel");
        }
        BranchStore bs = new BranchStore();
        //Cases to include all combinations of inputs
        try {
            if (cityId != 0 && branchId != 0) {
                ps = connect.prepareStatement("Select * from 14ac3d32.branch WHERE branchId=? AND cityId=?;");
                ps.setInt(1, branchId);
                ps.setInt(2, cityId);
            } else if ((cityId != 0) && (branchId == 0)) {
                ps = connect.prepareStatement("Select * from 14ac3d32.branch WHERE branchId=?");
                ps.setInt(1, cityId);
            } else if ((cityId == 0) && (branchId != 0)) {
                ps = connect.prepareStatement("Select * from 14ac3d32.branch WHERE cityId=?");
                ps.setInt(1, branchId);
            } else
                System.out.println("Something sucks at @BranchModel");

            rs = ps.executeQuery();
            while (rs.next()) {
                bs.setAddress(rs.getString("address"));
                bs.setBranchId(rs.getInt("branchId"));
                bs.setSize(rs.getInt("size"));
                bs.setExpenditure(rs.getInt("expenditure"));
                bs.setAdvertismentCosts(rs.getInt("advertismentCosts"));
                bs.setLeaseCost(rs.getInt("leaseCost"));
                bs.setRevenue(rs.getInt("revenue"));
            }
        } catch (Exception e) {

        }

        return bs;

    }
}
