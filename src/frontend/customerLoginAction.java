package frontend;

import beans.Customers;
import frontend_dao.customerLoginHibDao;
import common.sendMail;
import java.util.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

public class customerLoginAction extends ActionSupport implements SessionAware, ServletRequestAware{
/**
 * An object of the customerLoginHibDao class to validate login.
 * These methods will be invoked by the action class methods.
 */
    private customerLoginHibDao customerLoginService = new customerLoginHibDao();
/**
 * An object of the Customers bean class.
 * This object will be automatically populated by the Struts 2 framework based on the data captured by the data entry form.
 */
    private Customers customer;
/**
 * A string to hold error message, if any, which will be displayed in JSP.
 */
    private String message;
/**
 * A map object to hold current session.
 */
    private Map session;
/**
 * An object of HttpServletRequest to hold the Request data.
 */
    private HttpServletRequest request;

/**
 * A getter method for the object of the HttpServletRequest created earlier.
 * @return An object of HttpServletRequest.
 */
    public HttpServletRequest getServletRequest(){
        return request;
    }
/**
 * A setter method for the object of the HttpServletRequest created earlier.
 * @param request An object of HttpServletRequest.
 */
    public void setServletRequest(HttpServletRequest request){
        this.request = request;
    }

/**
 * A getter method for the current session.
 * @return The current session.
 */
    public Map getSession() {
        return session;
    }
/**
 * A setter method for the current session.
 * @param session The current session.
 */
    public void setSession(Map session) {
        this.session = session;
    }

/**
 * A getter method for the error message.
 * @return The error message.
 */
    public String getMessage() {
        return message;
    }

/**
 * A getter method for the customer object of the Customers bean class created earlier.
 * @return The Customers object.
 */
    public Customers getCustomer() {
        return customer;
    }
/**
 * A setter method for the customer object of the Customers bean class created earlier.
 * @param customer The Customers object.
 */
    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

/**
 * login() is invoked when the user keys in the login details and clicks login.
 * This method passes the login information to the DAO object's validateLogin() method, which validates and returns an object with the authenticated users data.
 * If the object holds user data then the same is added to the session.
 * If the object does not hold user data then an appropriate error message is send to JSP.
 * @throws java.lang.Exception
 */
    public String login() throws Exception {
        Customers objCustomer = (Customers) customerLoginService.validateLogin(customer.getUsername(), customer.getPassword(), request.getRemoteAddr());

        if(objCustomer != null){
            session = ActionContext.getContext().getSession();
            session.put("username", customer.getUsername());
            session.put("lastlogin", objCustomer.getLastLogin());
            session.put("lastip", objCustomer.getLastIP());
        }
        else {
            message = "Invalid Username or Password. Please try again";
            return ERROR;
        }
        return SUCCESS;
    }

/**
 * retrievePassword() is invoked when the user keys in the login details and clicks Fetch using the Forgot Password data entry form.
 * This method passes the login information to the DAO object's getPassword() method, which validates and returns an object with the authenticated users data.
 * If the object holds user data then the same is sent as an email to the customer's registered email address.
 * If the object does not hold user data then an appropriate error message is send to JSP.
 * @throws java.lang.Exception
 */
    public String retrievePassword() throws Exception {
        Customers objCustomers = (Customers) customerLoginService.getPassword(customer.getUsername(), customer.getEmailAddress());

        if(objCustomers != null){
            Locale locale = ActionContext.getContext().getLocale();
            ResourceBundle bundle = ResourceBundle.getBundle("bookshop", locale);
            if(!bundle.getString("emailFrom").equals("") && !bundle.getString("emailUser").equals("") && !bundle.getString("emailFromPasswd").equals("")) {
                String toEmailAddress = objCustomers.getEmailAddress();
                String emailSubject = "Sharanams Bookshop: Forgot Password mail.";
                String emailMessage = "<html><head><meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1'/><title>Your Password</title></head><body><table width='500' border='0' align='center' cellpadding='15' cellspacing='0' style='font-family:Verdana, Arial, Helvetica, sans-serif; font-size:12pt; color:#5a5a5a;'><tr><td align='left'><p>Dear " + objCustomers.getFirstName() + ",</p></td></tr><tr><td align='left'><p>As requested, please find your login details below:</p><br/><br/><p>Username: " + objCustomers.getUsername() + "<br />Password: " + objCustomers.getPassword() + "<br /></p><br/><p>Thank you for using  this site.<br /></p><br/><br/><p>Regards,<br />Sharanams Bookshop<br /></p><p><br /><br />THIS IS AN AUTOMATED MESSAGE; PLEASE DO NOT REPLY. </p></td></tr></table></body></html>";
                sendMail.sendMail(bundle.getString("emailFrom"), bundle.getString("emailUser"), bundle.getString("emailFromPasswd"), toEmailAddress, emailSubject, emailMessage);
            }
        }
        else {
            message = "Invalid Username or Email Address. Please try again";
            return ERROR;
        }
        return SUCCESS;
    }

/**
 * logoff() is invoked when the user clicks Logout.
 * This method removes the user data from the session and clears the session.
 * @throws java.lang.Exception
 */
    @SkipValidation
    public String logoff() throws Exception{
        session = ActionContext.getContext().getSession();
        session.remove("username");
        session.remove("lastlogin");
        session.remove("lastip");
        session.clear();
        return SUCCESS;
    }
}