package stores;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * Created by Administrator on 2014/11/20.
 */
public class customer {

    private String career=null;
    private java.sql.Date dob1=null;
    private java.sql.Date dob2=null;
    private int lcID;

    public void setCareer(String car) {
        this.career = car;
    }

    public String getCareer() {
        return this.career;
    }

    public void setID(int i) {
        this.lcID = i;
    }

    public int getID() {
        return this.lcID;
    }

    public void setDateOfBirth1(java.sql.Date d) {
        this.dob1 = d;
    }

    public java.sql.Date getDateOfBirth1() {
        return this.dob1;
    }

    public void setDateOfBirth2(java.sql.Date d) {
        this.dob2 = d;
    }

    public java.sql.Date getDateOfBirth2() {
        return this.dob2;
    }

    public java.sql.Date convert(String n)throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        java.util.Date parsed = format.parse(n);
        java.sql.Date sql = new java.sql.Date(parsed.getTime());
        return sql;
    }
}
