package stores;
import java.util.Date;
import java.util.LinkedList;
/**
 * Created by Administrator on 2014/11/10.
 */
public class Item {
    private String name = null;
    private double price = 0;
    private java.sql.Date time = null;
    public void setName(String n) {
        this.name = n;
    }

    public String getName() {
        return this.name;
    }

    public void setPrice(double p) {
        this.price = p;
    }

    public double getPrice() {
        return this.price;
    }

    public void setDate(java.sql.Date t) {
        this.time = t;
    }

    public java.sql.Date getDate() {
        return this.time;
    }
}

