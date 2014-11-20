package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 * Created by Drew on 20/11/2014.
 */
public class GeoPolitical {
    private Connection connect = null;
    private PreparedStatement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public LinkedList<stores.GeoPolitical> getGPolitical(String nameOfCountry) {
        LinkedList<stores.GeoPolitical> geoPoliticalList = new LinkedList<stores.GeoPolitical>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                    + "user=14ac3u32&password=cab123");
            statement = connect.prepareStatement("Select * from 14ac3d32.geopolitical WHERE nameOfCountry=?;");
            statement.setString(1, nameOfCountry);
            resultSet = statement.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    stores.GeoPolitical geoPolitical = new stores.GeoPolitical();
                    geoPolitical.setNameOfCountry(resultSet.getString("nameOfCountry"));
                    geoPolitical.setEmbargo(resultSet.getInt("embargo"));
                    geoPolitical.setSanctions(resultSet.getInt("sanctions"));
                    geoPolitical.setVisa(resultSet.getInt("visa"));
                    geoPolitical.setRiot(resultSet.getInt("riot"));
                    geoPoliticalList.add(geoPolitical);
                }
            } else {
                System.out.println("SQL did not return any GeoPolitical , yo");
            }
        } catch (Exception e) {

        }
        return geoPoliticalList;
    }
}
