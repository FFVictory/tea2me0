package models;

import sun.awt.image.ImageWatched;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 * Created by Drew on 21/11/2014.
 */
public class Certification {
    private Connection connect = null;
    private PreparedStatement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public LinkedList<stores.Certification> showCertificates() {
        LinkedList<stores.Certification> certificateList = new LinkedList<stores.Certification>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                    + "user=14ac3u32&password=cab123");
            statement = connect.prepareStatement("Select * from 14ac3d32.view_certifications;");
            resultSet = statement.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    stores.Certification certificate = new stores.Certification();
                    certificate.setTeaName(resultSet.getString("teaName"));
                    certificate.setSalePrice(resultSet.getInt("salePrice"));
                    certificate.setBuyPrice(resultSet.getInt("buyPrice"));
                    certificate.setTypeOfTea(resultSet.getString("typeOfTea"));
                    certificate.setTeaId(resultSet.getInt("teaId"));
                    certificate.setUk(resultSet.getBoolean("uk"));
                    certificate.setUsa(resultSet.getBoolean("usa"));
                    certificate.setFinland(resultSet.getBoolean("finland"));
                    certificate.setRussia(resultSet.getBoolean("russia"));
                    certificate.setGermany(resultSet.getBoolean("germany"));
                    certificate.setNetherlands(resultSet.getBoolean("netherlands"));
                    certificate.setChina(resultSet.getBoolean("china"));
                    certificateList.add(certificate);
                }

            } else {
                System.out.println("SQL Failed");
            }
        } catch (Exception e) {

        }
        return certificateList;
    }
}
