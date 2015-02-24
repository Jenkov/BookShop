package beans;

public class Publishers implements java.io.Serializable{
    private int PublisherNo;
    private Integer CityStateNo, CountryNo;
    private String PublisherName, EmailAddress, Address1, Address2, Pincode;

    public Publishers() {
    }

    public Integer getCityStateNo() {
        return CityStateNo;
    }

    public void setCityStateNo(Integer CityStateNo) {
        this.CityStateNo = CityStateNo;
    }

    public Integer getCountryNo() {
        return CountryNo;
    }

    public void setCountryNo(Integer CountryNo) {
        this.CountryNo = CountryNo;
    }

    public String getAddress1() {
        return Address1;
    }

    public void setAddress1(String Address1) {
        this.Address1 = Address1;
    }

    public String getAddress2() {
        return Address2;
    }

    public void setAddress2(String Address2) {
        this.Address2 = Address2;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String EmailAddress) {
        this.EmailAddress = EmailAddress;
    }

    public String getPincode() {
        return Pincode;
    }

    public void setPincode(String Pincode) {
        this.Pincode = Pincode;
    }

    public String getPublisherName() {
        return PublisherName;
    }

    public void setPublisherName(String PublisherName) {
        this.PublisherName = PublisherName;
    }

    public int getPublisherNo() {
        return PublisherNo;
    }

    public void setPublisherNo(int PublisherNo) {
        this.PublisherNo = PublisherNo;
    }
}