package models;

import stores.NaturalDisaster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 * Created by Drew on 19/11/2014.
 */
public class DisastersModel {
    private Connection connect = null;
    private PreparedStatement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public java.util.LinkedList<NaturalDisaster> getDisasters(String nameOfCountry){
        LinkedList<NaturalDisaster> naturalDisastersList = new LinkedList<NaturalDisaster>() ;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                    + "user=14ac3u32&password=cab123");
            statement = connect.prepareStatement("Select * from 14ac3d32.naturaldisasters WHERE nameOfCountry=?;");
            statement.setString(1, nameOfCountry);
            resultSet = statement.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    NaturalDisaster naturalDisaster = new NaturalDisaster();
                    naturalDisaster.setNameOfCountry(resultSet.getString("nameOfCountry"));
                    naturalDisaster.setTornado(resultSet.getInt("tornado"));
                    naturalDisaster.setTsunami(resultSet.getInt("tsunami"));
                    naturalDisaster.setVolcanoEruptions(resultSet.getInt("volcanoEruptions"));
                    naturalDisaster.setFlood(resultSet.getInt("flood"));
                    naturalDisastersList.add(naturalDisaster);
                }
            } else {
                System.out.println("SQL did not return any disasters , unlike the project...");
            }
        }
        catch(Exception e){

        }
        return naturalDisastersList;
    }


}
