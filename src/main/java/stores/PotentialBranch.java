package stores;

import java.util.LinkedList;

/**
 * Created by Drew on 20/11/2014.
 */
public class PotentialBranch {
    int branchId, leaseCost, projectedProfit, projectedExpenditure, cityId;
    String country;

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getLeaseCost() {
        return leaseCost;
    }

    public void setLeaseCost(int leaseCost) {
        this.leaseCost = leaseCost;
    }

    public int getProjectedProfit() {
        return projectedProfit;
    }

    public void setProjectedProfit(int projectedProfit) {
        this.projectedProfit = projectedProfit;
    }

    public int getProjectedExpenditure() {
        return projectedExpenditure;
    }

    public void setProjectedExpenditure(int projectedExpenditure) {
        this.projectedExpenditure = projectedExpenditure;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
