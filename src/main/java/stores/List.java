package stores;

import java.util.Iterator;

/**
 * Created by Administrator on 2014/11/17.
 */
public class List {

    private java.util.LinkedList<Item> item = new java.util.LinkedList<>();

    public List(){

    }
    public boolean setItem(Item n) {
        return this.item.add(n);
    }

    public java.util.LinkedList<Item> getItem() {
        return this.item;
    }

    public void resetItem() {
        this.item=null;
    }

}
