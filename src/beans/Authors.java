package beans;

import java.sql.Blob;

public class Authors implements java.io.Serializable{
    private int AuthorNo;
    private Integer CityStateNo, CountryNo;
    private String FirstName, LastName, Address1, Address2, Pincode, Degree, EmailAddress, Speciality, Dob;
    private Blob Photograph;

    public Authors() {
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

    public int getAuthorNo() {
        return AuthorNo;
    }

    public void setAuthorNo(int AuthorNo) {
        this.AuthorNo = AuthorNo;
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

    public String getDob() {
        return Dob;
    }

    public void setDob(String Dob) {
        this.Dob = Dob;
    }

    public String getDegree() {
        return Degree;
    }

    public void setDegree(String Degree) {
        this.Degree = Degree;
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

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public Blob getPhotograph() {
        return Photograph;
    }

    public void setPhotograph(Blob Photograph) {
        this.Photograph = Photograph;
    }

    public String getPincode() {
        return Pincode;
    }

    public void setPincode(String Pincode) {
        this.Pincode = Pincode;
    }

    public String getSpeciality() {
        return Speciality;
    }

    public void setSpeciality(String Speciality) {
        this.Speciality = Speciality;
    }
}