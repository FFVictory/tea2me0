package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 * Created by Drew on 20/11/2014.
 */
public class PotentialBranch {
    private Connection connect = null;
    private PreparedStatement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public LinkedList<stores.PotentialBranch> getBranches() {
        LinkedList<stores.PotentialBranch> branchList = new LinkedList<stores.PotentialBranch>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                    + "user=14ac3u32&password=cab123");
            statement = connect.prepareStatement("Select * from view_potential_branch");
            resultSet = statement.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    stores.PotentialBranch potentialBranch = new stores.PotentialBranch();
                    potentialBranch.setBranchId(resultSet.getInt("pBranchID"));
                    potentialBranch.setLeaseCost(resultSet.getInt("leaseCost"));
                    potentialBranch.setProjectedProfit(resultSet.getInt("projectedProfit"));
                    potentialBranch.setProjectedExpenditure(resultSet.getInt("projectedExpenditure"));
                    potentialBranch.setCityId(resultSet.getInt("cityId"));
                    potentialBranch.setCountry(resultSet.getString("country"));
                    branchList.add(potentialBranch);
                }
            }
        } catch (Exception e) {
            System.out.println("SQL returned no branches @getBranches");
        }
        return branchList;
    }
}
