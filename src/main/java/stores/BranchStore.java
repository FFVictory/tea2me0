package stores;

/**
 * Created by Drew on 19/11/2014.
 */
public class BranchStore {
    int branchId;
    int size;
    String address;
    int expenditure;
    int advertismentCosts;
    int revenue;
    int cityId;
    int leaseCost;
    String supplierName;
    int teaQuality;
    int cRating;

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(int expenditure) {
        this.expenditure = expenditure;
    }

    public int getAdvertismentCosts() {
        return advertismentCosts;
    }

    public void setAdvertismentCosts(int advertismentCosts) {
        this.advertismentCosts = advertismentCosts;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getLeaseCost() {
        return leaseCost;
    }

    public void setLeaseCost(int leaseCost) {
        this.leaseCost = leaseCost;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public int getTeaQuality() {
        return teaQuality;
    }

    public void setTeaQuality(int teaQuality) {
        this.teaQuality = teaQuality;
    }

    public int getcRating() {
        return cRating;
    }

    public void setcRating(int cRating) {
        this.cRating = cRating;
    }
}
