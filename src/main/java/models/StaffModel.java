package models;

import stores.FoundStaff;
import java.sql.*;
import java.util.LinkedList;

/**
 * Created by Christopher on 20/11/2014.
 */
public class StaffModel {

    private static Connection connect = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public LinkedList<FoundStaff> getStaff(int branchId, int position) {

        LinkedList<FoundStaff> search = new LinkedList<>();
        boolean dbCon = true;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                    + "user=14ac3u32&password=cab123");
            if(position == 2) {
                preparedStatement = connect.prepareStatement("select * from 14ac3d32.staffmember where position = 1 and branchId =?;");
                preparedStatement.setInt(1, branchId);
            }else if(position == 3) {
                preparedStatement = connect.prepareStatement("select * from 14ac3d32.staffmember where position = 2;");
            }
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                FoundStaff foundItem = new FoundStaff();

                foundItem.setStaffId(resultSet.getInt("staffId")) ;
                foundItem.setFirstName(resultSet.getString("firstName"));
                foundItem.setLastName(resultSet.getString("lastName"));
                foundItem.setAddress(resultSet.getString("address"));
                foundItem.setBranchId(resultSet.getInt("BranchId")) ;
                foundItem.setTraining(resultSet.getString("training"));

                search.push(foundItem);

            }

        } catch (Exception ex) {
            System.out.println(ex);
            dbCon = false;
        } finally {
            try {
                if(dbCon) {
                    resultSet.close();
                    preparedStatement.close();
                    connect.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return search;
    }
}
