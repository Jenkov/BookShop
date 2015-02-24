package beans;

public class Countries implements java.io.Serializable{
    private int CountryNo;
    private String Country;

    public Countries() {
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public int getCountryNo() {
        return CountryNo;
    }

    public void setCountryNo(int CountryNo) {
        this.CountryNo = CountryNo;
    }
}