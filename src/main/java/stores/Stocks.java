package stores;

/**
 * Created by Andrew on 06/11/2014.
 */
public class Stocks {
    int branchId;
    int stockRequested;
    String teaType;
    String teaName;

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getStockRequested() {
        return stockRequested;
    }

    public void setStockRequested(int stockRequested) {
        this.stockRequested = stockRequested;
    }

    public String getTeaType() {
        return teaType;
    }

    public void setTeaType(String teaType) {
        this.teaType = teaType;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }
}
