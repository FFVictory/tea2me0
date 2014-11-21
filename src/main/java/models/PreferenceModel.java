package models;

import stores.vote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

/**
 * Created by Administrator on 2014/11/20.
 */
public class PreferenceModel {
    private Connection connect = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    public PreferenceModel(){

    }
    public int[] getPreferData(java.util.LinkedList<Integer> id){

        //java.util.LinkedList<Integer> id = new java.util.LinkedList<>();
        //id=(java.util.LinkedList<Integer>)session.getAttribute("LoyaltyCardID");
        Iterator<Integer> iterator;
        iterator = id.iterator();
        String i=null;
        vote v = new vote();
        int[] num = new int[12];
        for(int counter=0; counter<13; counter++){
            num[counter]=0;
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306?"
                    + "user=14ac3u32&password=cab123");
            while (iterator.hasNext()) {//first loop for linkedlist
                preparedStatement = connect.prepareStatement("Select products from 14ac3d32.order WHERE loyaltyCardID=");
                resultSet = preparedStatement.executeQuery();

                while (!(resultSet.isAfterLast())) {//second loop for resultSet
                    i = resultSet.getString("products");
                    switch(i)
                    {
                        case "Earl Grey": num[1]++;
                            break;
                        case "Breakfast":  num[2]++;
                            break;
                        case "Fruit":  num[3]++;
                            break;
                        case "Standard Green":  num[4]++;
                            break;
                        case "Flavoured": num[5]++;
                            break;
                        case "White":  num[6]++;
                            break;
                        case "Yellow":  num[7]++;
                            break;
                        case "Dark":  num[8]++;
                            break;
                        case "Black":  num[9]++;
                            break;
                        case "Herb":  num[10]++;
                            break;
                        case "Oolong":  num[11]++;
                            break;
                        case "West Lake":  num[12]++;
                            break;
                        default: num[0]++;
                            break;
                    }
                    resultSet.next();
                }
            }
            v.setVote(num);
            preparedStatement.close();
            connect.close();
        } catch (Exception e) {
            System.out.println("Exception at PreferenceModel");
        }
        return v.getVote();

    }
}
