package models;

import java.util.LinkedList;

/**
 * Created by Drew on 20/11/2014.
 */
public class PotentialBranch {
    public LinkedList<stores.PotentialBranch> getBranches() {
        LinkedList<stores.PotentialBranch> branchList = new LinkedList<stores.PotentialBranch>();
        try {

        } catch (Exception e) {
            System.out.println("SQL returned no branches @getBranches");
        }
        return branchList;
    }
}
