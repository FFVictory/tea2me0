package stores;

/**
 * Created by Christopher on 20/11/2014.
 */

public class FoundStaff {

    String firstName = null;
    String lastName = null;
    String address = null;
    String training = null;

    int staffId = 0;
    int branchId = 0;
    int position = 0;

    public void setFirstName(String name){
        this.firstName=name;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setAddress(String name){
        this.address=name;
    }

    public String getAddress(){
        return address;
    }

    public void setTraining(String name){
        this.training=name;
    }

    public String getTraining(){
        return training;
    }

    public void setLastName(String name){
        this.lastName=name;
    }

    public String getLastName(){
        return lastName;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setStaffId(int ID){
        this.staffId=ID;
    }

    public int getStaffId(){
        return staffId;
    }

}
