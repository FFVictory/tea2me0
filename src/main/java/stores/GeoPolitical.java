package stores;

/**
 * Created by Drew on 20/11/2014.
 */
public class GeoPolitical {
    int embargo, sanctions, visa, riot;
    String nameOfCountry;

    public int getEmbargo() {
        return embargo;
    }

    public void setEmbargo(int embargo) {
        this.embargo = embargo;
    }

    public int getSanctions() {
        return sanctions;
    }

    public void setSanctions(int sanctions) {
        this.sanctions = sanctions;
    }

    public int getVisa() {
        return visa;
    }

    public void setVisa(int visa) {
        this.visa = visa;
    }

    public int getRiot() {
        return riot;
    }

    public void setRiot(int riot) {
        this.riot = riot;
    }

    public String getNameOfCountry() {
        return nameOfCountry;
    }

    public void setNameOfCountry(String nameOfCountry) {
        this.nameOfCountry = nameOfCountry;
    }
}
