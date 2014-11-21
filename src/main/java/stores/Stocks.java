package stores;

/**
 * Created by Andrew on 06/11/2014.
 */
public class Stocks {
    int branchId,teaType,stock,stockRequested;

    public int getTeaType(){return teaType;}
    public int getStock(){return stock;}
    public int getBranchId(){return branchId;}
    public int getStockRequested(){return stockRequested;}
    public void setStockRequested(int stockReq){this.stockRequested=stockReq;}
    public void setTeaType(int tea){this.teaType = tea; }
    public void setStock(int stock){this.stock= stock; }
    public void setBranchId(int  branchId){this.branchId= branchId; }


}
