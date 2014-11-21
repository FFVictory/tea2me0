package stores;

/**
 * Created by Drew on 21/11/2014.
 */
public class Certification {
    String teaName, typeOfTea;
    boolean uk, usa, finland, russia, germany, netherlands, china;
    int salePrice, buyPrice, teaId;

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getTypeOfTea() {
        return typeOfTea;
    }

    public void setTypeOfTea(String typeOfTea) {
        this.typeOfTea = typeOfTea;
    }

    public boolean isUk() {
        return uk;
    }

    public void setUk(boolean uk) {
        this.uk = uk;
    }

    public boolean isUsa() {
        return usa;
    }

    public void setUsa(boolean usa) {
        this.usa = usa;
    }

    public boolean isFinland() {
        return finland;
    }

    public void setFinland(boolean finland) {
        this.finland = finland;
    }

    public boolean isRussia() {
        return russia;
    }

    public void setRussia(boolean russia) {
        this.russia = russia;
    }

    public boolean isGermany() {
        return germany;
    }

    public void setGermany(boolean germany) {
        this.germany = germany;
    }

    public boolean isNetherlands() {
        return netherlands;
    }

    public void setNetherlands(boolean netherlands) {
        this.netherlands = netherlands;
    }

    public boolean isChina() {
        return china;
    }

    public void setChina(boolean china) {
        this.china = china;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getTeaId() {
        return teaId;
    }

    public void setTeaId(int teaId) {
        this.teaId = teaId;
    }
}
