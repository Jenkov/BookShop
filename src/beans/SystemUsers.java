package beans;

public class SystemUsers implements java.io.Serializable{
    private int UserNo;
    private String Username, Password, EmailAddress, FirstName, LastName, ManageCountries, ManageCityState, ManageAuthors, ManagePublishers, ManageCategories, ManageUsers, ManageBooks, ManageCustomers, ManageTransactions, LastLogin;

    public SystemUsers() {
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

    public String getLastLogin() {
        return LastLogin;
    }

    public void setLastLogin(String LastLogin) {
        this.LastLogin = LastLogin;
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

    public String getManageAuthors() {
        return ManageAuthors;
    }

    public void setManageAuthors(String ManageAuthors) {
        this.ManageAuthors = ManageAuthors;
    }

    public String getManageBooks() {
        return ManageBooks;
    }

    public void setManageBooks(String ManageBooks) {
        this.ManageBooks = ManageBooks;
    }

    public String getManageCategories() {
        return ManageCategories;
    }

    public void setManageCategories(String ManageCategories) {
        this.ManageCategories = ManageCategories;
    }

    public String getManageCityState() {
        return ManageCityState;
    }

    public void setManageCityState(String ManageCityState) {
        this.ManageCityState = ManageCityState;
    }

    public String getManageCountries() {
        return ManageCountries;
    }

    public void setManageCountries(String ManageCountries) {
        this.ManageCountries = ManageCountries;
    }

    public String getManageCustomers() {
        return ManageCustomers;
    }

    public void setManageCustomers(String ManageCustomers) {
        this.ManageCustomers = ManageCustomers;
    }

    public String getManagePublishers() {
        return ManagePublishers;
    }

    public void setManagePublishers(String ManagePublishers) {
        this.ManagePublishers = ManagePublishers;
    }

    public String getManageTransactions() {
        return ManageTransactions;
    }

    public void setManageTransactions(String ManageTransactions) {
        this.ManageTransactions = ManageTransactions;
    }

    public String getManageUsers() {
        return ManageUsers;
    }

    public void setManageUsers(String ManageUsers) {
        this.ManageUsers = ManageUsers;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getUserNo() {
        return UserNo;
    }

    public void setUserNo(int UserNo) {
        this.UserNo = UserNo;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }
}