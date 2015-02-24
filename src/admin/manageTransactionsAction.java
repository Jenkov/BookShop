package admin;

import admin_dao.TransactionsHibDao;
import beans.Customers;
import beans.Transactions;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.validation.SkipValidation;

public class manageTransactionsAction extends ActionSupport{
/**
 * An object of the TransactionsHibDao class to view the details of transactions for a particular username.
 * Methods of this object will be invoked to service these data operation requests.
 * These methods will be invoked by the action class methods.
 */
    private TransactionsHibDao transactionsService = new TransactionsHibDao();
/**
 * A List type object of the Transactions bean class.
 * This List object will be populated by the view() method with the records available in the Transactions table.
 * This List object will be used to display existing records in the JSP page's data grid.
 */
    private List<Transactions> transactions;
/**
 * A List type object of the Customers bean class.
 * This List object will be populated by the populateUsernames() method with the records available in the Customers table.
 * This List object will be used to display existing records in the JSP page's drop down list box.
 */
    private List<Customers> ddlbUsernames;
/**
 * A variable used to populate the drop down list box with the usernames retrieved from the Customers table.
 */
    private String Username;

/**
 * A getter method for the List object of the Transactions bean class created earlier.
 * This list will be made available to the JSP page for displaying transaction details data grid.
 * @return A list object of Transactions.
 */
    public List<Transactions> getTransactions() {
        return transactions;
    }
/**
 * A setter method for the List object of the Transactions bean class created earlier.
 * This list will be made available to the JSP page for displaying transaction details data grid.
 * @param transactions A list object of Transactions.
 */
    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

/**
 * A getter method for the List object of the Customers bean class created earlier.
 * This list will be made available to the JSP page for displaying username details in the drop down list box.
 * @return A list object of Customers.
 */
    public List<Customers> getDdlbUsernames() {
        return ddlbUsernames;
    }
/**
 * A setter method for the List object of the Customers bean class created earlier.
 * This list will be made available to the JSP page for displaying username details in the drop down list box.
 * @param ddlbUsernames A list object of Customers.
 */
    public void setDdlbUsernames(List<Customers> ddlbUsernames) {
        this.ddlbUsernames = ddlbUsernames;
    }

/**
 * A getter method for the username.
 * This page number will be received as a parameter from the JSP page when a user selects the username from the drop down list box.
 * @return The username.
 */
    public String getUsername() {
        return Username;
    }
/**
 * A setter method for the username.
 * This page number will be received as a parameter from the JSP page when a user selects the username from the drop down list box.
 * @param Username The username.
 */
    public void setUsername(String Username) {
        this.Username = Username;
    }

/**
 * populateUsername() populates the list object.
 * This list object will be made available to the action class's view() method.
 * @SkipValidation is used to skip validation for this method.
 */
    @SkipValidation
    public String populateUsernames(){
        ddlbUsernames = transactionsService.getAllUsernames();
        return SUCCESS;
    }

/**
 * view() method is invoked everytime the JSP page is served.
 * It populates the List object [transactions] created earlier which will be used in the JSP page's <s:iterator> tag to form the data grid.
 * This data grid displays existing records from the Transactions table.
 * @SkipValidation is used to skip validation for this method.
 */
    @SkipValidation
    public String view() throws Exception{
        populateUsernames();
        transactions = transactionsService.getAllEntries(Username);
        return SUCCESS;
    }
}