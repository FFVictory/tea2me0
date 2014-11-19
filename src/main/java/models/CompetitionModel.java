package models;

import stores.Competition;
import stores.Stocks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 * Created by Drew on 19/11/2014.
 */
public class CompetitionModel {
    private Connection connect = null;
    private PreparedStatement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public java.util.LinkedList<Competition> findCompetition(String countryName) {
        LinkedList<Competition> competitionList = new LinkedList<Competition>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                    + "user=14ac3u32&password=cab123");
            statement = connect.prepareStatement("SELECT * from 14ac3d32.competition WHERE nameOfCountry=?;");
            statement.setString(1, countryName);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Competition competition = new Competition();
                competition.setCompetitionId(resultSet.getInt("CompetitionID"));
                competition.setName(resultSet.getString("name"));
                competition.setMarketShare(resultSet.getInt("marketShare"));
                competition.setProfit(resultSet.getInt("profit"));
                competition.setAddress(resultSet.getString("address"));
                competition.setNameOfCountry(resultSet.getString("nameOfCountry"));
                competitionList.add(competition);
            }
        } catch (Exception e) {
            System.out.println("Exception at findCompetition");
        }
        return competitionList;
    }

}
