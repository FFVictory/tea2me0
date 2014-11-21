package stores;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by KJ on 2014/11/19.
 */
public class Loyaltycard {


    private String fname=null;
    private String lname=null;
    private String city=null;
    private String career=null;
    private java.sql.Date dob=null;
    private String gender=null;
    private int lcID=100000;
    //private int bonusPoints=0;
    public void setFname(String f) {
        this.fname = f;
    }

    public String getFname() {
        return this.fname;
    }

    public void setLname(String l) {
        this.lname = l;
    }

    public String getLname() {
        return this.lname;
    }

    public void setCity(String c) {
        this.city = c;
    }

    public String getCity() {
        return this.city;
    }

    public void setCareer(String car) {
        this.career = car;
    }

    public String getCareer() {
        return this.career;
    }

    public void setGender(String g) {
        this.gender = g;
    }

    public String getGender() {
        return this.gender;
    }

   /* public void setBonusPoint(int bp) {
        this.bonusPoints = bp;
    }

    public int getBonusPoint() {
        return this.bonusPoints;
    }*/

    public void setID(int i) {
        this.lcID = i;
    }

    public int getID() {
        return this.lcID;
    }

    public void setDateOfBirth(java.sql.Date d) {
        this.dob = d;
    }

    public java.sql.Date getDateOfBirth() {
        return this.dob;
    }

    public java.sql.Date convert(String n)throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        java.util.Date parsed = format.parse(n);
        java.sql.Date sql = new java.sql.Date(parsed.getTime());
        return sql;
    }

}
