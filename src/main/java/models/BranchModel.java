package models;

import stores.BranchStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 * Created by Drew on 19/11/2014.
 */
public class BranchModel {
    private PreparedStatement ps = null;
    private Connection connect = null;
    private ResultSet rs = null;

    public LinkedList<BranchStore> findBranch(int cityId, int branchId) {
        System.out.println("BranchModel.findBranch ");
        LinkedList<BranchStore> bsl = new LinkedList<BranchStore>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                    + "user=14ac3u32&password=cab123");
        } catch (Exception e) {
            System.out.println("Error with DB connection @BranchModel");
        }
        //Cases to include all combinations of inputs
        try {
            if (cityId != 0 && branchId != 0) {
                ps = connect.prepareStatement("Select * from 14ac3d32.view_branch_w_suppliers WHERE branchId=? AND cityId=?;");
                ps.setInt(1, branchId);
                ps.setInt(2, cityId);
            } else if ((cityId != 0) && (branchId == 0)) {
                ps = connect.prepareStatement("Select * from 14ac3d32.view_branch_w_suppliers WHERE cityId=?");
                ps.setInt(1, cityId);
            } else if ((cityId == 0) && (branchId != 0)) {
                ps = connect.prepareStatement("Select * from 14ac3d32.view_branch_w_suppliers WHERE branchId=?");
                ps.setInt(1, branchId);
            } else
                System.out.println("Something sucks at @BranchModel");

            rs = ps.executeQuery();
            while (rs.next()) {
        BranchStore bs = new BranchStore();
                bs.setBranchId(rs.getInt("branchId"));
                bs.setSize(rs.getInt("size"));
                bs.setAddress(rs.getString("address"));
                bs.setExpenditure(rs.getInt("expenditure"));
                bs.setAdvertismentCosts(rs.getInt("advertismentCosts"));
                bs.setRevenue(rs.getInt("revenue"));
                bs.setCityId(rs.getInt("cityId"));
                bs.setLeaseCost(rs.getInt("leaseCost"));
                bs.setSupplierName(rs.getString("name"));
                bs.setTeaQuality(rs.getInt("teaQUality"));
                bs.setcRating(rs.getInt("cRating"));
                bsl.add(bs);
            }
        } catch (Exception e) {

        }

        return bsl;

    }

    public void UpdateBranch(int branchId, int size, String address, int expenditure, int advertismentCosts, int leaseCost, int revenue, int cityId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                    + "user=14ac3u32&password=cab123");
            ps = connect.prepareStatement("UPDATE 14ac3d32.branch SET size=?, address=?, expenditure=?, advertismentCosts=? ,leaseCost=? , revenue=? , cityId=? where branchId=?;");
            ps.setInt(1, size);
            ps.setString(2, address);
            ps.setInt(3, expenditure);
            ps.setInt(4, advertismentCosts);
            ps.setInt(5, leaseCost);
            ps.setInt(6, revenue);
            ps.setInt(7, cityId);
            ps.setInt(8, branchId);
            ps.executeUpdate();

        } catch (Exception ex) {
            System.out.println("Something went wrong @BranchMode.UpdateBranch()");

        }
    }
}
