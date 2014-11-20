package stores;

/**
 * Created by Drew on 19/11/2014.
 */
public class NaturalDisaster {
    String nameOfCountry;
    int tornado,tsunami,volcanoEruptions,flood;

    public String getNameOfCountry() {
        return nameOfCountry;
    }

    public void setNameOfCountry(String nameOfCountry) {
        this.nameOfCountry = nameOfCountry;
    }

    public int getTornado() {
        return tornado;
    }

    public void setTornado(int tornado) {
        this.tornado = tornado;
    }

    public int getTsunami() {
        return tsunami;
    }

    public void setTsunami(int tsunami) {
        this.tsunami = tsunami;
    }

    public int getVolcanoEruptions() {
        return volcanoEruptions;
    }

    public void setVolcanoEruptions(int volcanoEruptions) {
        this.volcanoEruptions = volcanoEruptions;
    }

    public int getFlood() {
        return flood;
    }

    public void setFlood(int flood) {
        this.flood = flood;
    }
}
