package stores;

/**
 * Created by Andrew on 06/11/2014.
 */
public class Stocks {
    int branchId;
    int teaType;
    int teaName;

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getTeaType() {
        return teaType;
    }

    public void setTeaType(int teaType) {
        this.teaType = teaType;
    }

    public int getTeaName() {
        return teaName;
    }

    public void setTeaName(int teaName) {
        this.teaName = teaName;
    }

    public int getStockRequested() {
        return stockRequested;
    }

    public void setStockRequested(int stockRequested) {
        this.stockRequested = stockRequested;
    }

    int stockRequested;


}
