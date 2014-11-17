package stores;

public class LoggedIn {
    boolean logedin=false;
    String first_name=null;
    String last_name=null;
    String staff_ID=null;
    int branchId = 0;
    String skill=null;
    
    int position;
    
    public void LogedIn(){
        
    }

    public void setLogedin(){
        logedin=true;
    }
    public void setLogedout(){
        logedin=false;
    }
    public void setfirst_name(String name){
        this.first_name=name;
    }
    public String getfirst_name(){
        return first_name;
    }
    public void setlast_name(String name){
        this.last_name=name;
    }
    public String getlast_name(){
        return last_name;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getBranchId() {
        return branchId;
    }
    public void setstaff_ID(String ID){
        this.staff_ID=ID;
    }
    public String getstaff_ID(){
        return staff_ID;
    }
    public void setPosition(int pos){
        this.position=pos;
    }
    public int getPosition(){
        return position;
    }
    public void setSkills(String ski){
        this.skill=ski;
    }
    public String getSkills(){
        return skill;
    }
    public void setLoginState(boolean logedin){
        this.logedin=logedin;
    }
    public boolean getlogedin(){
        return logedin;
    }

	public void setPosition1(int pos) {
		// TODO Auto-generated method stub
		
	}///////////////for what?
}
