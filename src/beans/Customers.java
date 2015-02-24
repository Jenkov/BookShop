package beans;

public class Customers implements java.io.Serializable{
    private int CustomerNo;
    private Integer CityStateNo, CountryNo;
    private String Username, Password, EmailAddress, FirstName, LastName, Address1, Address2, Pincode, Dob, NewRelease, BookUpdates, LastLogin, LastIP;

    public Customers() {
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

    public String getBookUpdates() {
        return BookUpdates;
    }

    public void setBookUpdates(String BookUpdates) {
        this.BookUpdates = BookUpdates;
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

    public int getCustomerNo() {
        return CustomerNo;
    }

    public void setCustomerNo(int CustomerNo) {
        this.CustomerNo = CustomerNo;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String Dob) {
        this.Dob = Dob;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String EmailAddress) {
        this.EmailAddress = EmailAddress;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastIP() {
        return LastIP;
    }

    public void setLastIP(String LastIP) {
        this.LastIP = LastIP;
    }

    public String getLastLogin() {
        return LastLogin;
    }

    public void setLastLogin(String LastLogin) {
        this.LastLogin = LastLogin;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getNewRelease() {
        return NewRelease;
    }

    public void setNewRelease(String NewRelease) {
        this.NewRelease = NewRelease;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPincode() {
        return Pincode;
    }

    public void setPincode(String Pincode) {
        this.Pincode = Pincode;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }
}