package frontend;

import beans.Customers;
import common.populateDdlbs;
import common.sendMail;
import frontend_dao.registrationHibDao;
import java.util.Locale;
import java.util.ResourceBundle;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.validation.SkipValidation;

public class registrationAction extends ActionSupport{
/**
 * An object of the registrationHibDao class to service data operation requests such as Insert.
 * Methods of this object will be invoked to service these data operation requests.
 * These methods will be invoked by the action class methods.
 */
    private registrationHibDao registrationService = new registrationHibDao();
/**
 * An object of the populateDdlbs class to service data operation requests
 * such as Populating DDLBs.
 */
    private populateDdlbs ddlb = new populateDdlbs();
/**
 * An object of the Customers bean class.
 * This object will be automatically populated by the Struts 2 framework based on the data captured by the data entry form.
 */
    private Customers customer;

/**
 * A getter method for the populateDdlbs which will make available the populated list object for the drop down list boxes.
 * @return The populateDdlbs object.
 */
    public populateDdlbs getDdlb() {
        return ddlb;
    }
/**
 * A setter method for the populateDdlbs which will make available the populated list object for the drop down list boxes.
 * @param ddlb The populateDdlbs object.
 */
    public void setDdlb(populateDdlbs ddlb) {
        this.ddlb = ddlb;
    }

/**
 * A getter method for the author object of the Customers bean class created earlier.
 * @return The Customers object.
 */
    public Customers getCustomer() {
        return customer;
    }
/**
 * A setter method for the author object of the Customers bean class created earlier.
 * @param customer The Customers object.
 */
    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

/**
 * execute() method is invoked when the user clicks Signup to register.
 * This method makes available the drop down list box values to the Registration data entry form.
 */
    @SkipValidation
    @Override
    public String execute(){
        return SUCCESS;
    }

/**
 * insert() method is invoked when a user keys in the desired data and clicks Save.
 * It performs an insert operation [using DAO object's insert() method].
 * The captured form data is passed to the DAO object's methods using the parameterized constructor of the Customers bean class.
 */
    public String insert() throws Exception{
        try{
            registrationService.insert(customer);
            registrationThankYouMail();
        }
        catch (Exception e){
            addActionError(e.getCause().toString().split("[:]")[1]);
            return ERROR;
        }
        return SUCCESS;
    }

/**
 * registrationThankYouMail() when invoked sends an email to the registered user.
 * This method is invoked by the insert() method after the user is registered.
 * @throws java.lang.Exception
 */
    @SkipValidation
    public String registrationThankYouMail() throws Exception{
       	Locale locale = ActionContext.getContext().getLocale();
    	ResourceBundle bundle = ResourceBundle.getBundle("bookshop", locale);
        if(!bundle.getString("emailFrom").equals("") && !bundle.getString("emailUser").equals("") && !bundle.getString("emailFromPasswd").equals("")) {
            String toEmailAddress = customer.getEmailAddress();
            String emailSubject = "Sharanams Bookshop: Registration mail.";
            String emailMessage = "<html><head><meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1'/><title>Your Registration Details</title></head><body><table width='500' border='0' align='center' cellpadding='15' cellspacing='0' style='font-family:Verdana, Arial, Helvetica, sans-serif; font-size:12pt; color:#5a5a5a;'><tr><td align='left'><p>Dear " + customer.getFirstName() + ",</p></td></tr><tr><td align='left'><p>Your login details are:</p><br/><br/><p>Username: " + customer.getUsername() + "<br />Password: " + customer.getPassword() + "<br /></p><br/><p>Thank you for using  this site.<br /></p><br/><br/><p>Regards,<br />Sharanams Bookshop<br /></p><p><br /><br />THIS IS AN AUTOMATED MESSAGE; PLEASE DO NOT REPLY. </p></td></tr></table></body></html>";
            sendMail.sendMail(bundle.getString("emailFrom"), bundle.getString("emailUser"), bundle.getString("emailFromPasswd"), toEmailAddress, emailSubject, emailMessage);
        }
        return SUCCESS;
    }
}