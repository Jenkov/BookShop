package admin;

import admin_dao.LoginHibDao;
import beans.SystemUsers;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

public class loginAction extends ActionSupport implements SessionAware{
/**
 * An object of the LoginHibDao class to validate login.
 * These methods will be invoked by the action class methods.
 */
    private LoginHibDao loginService = new LoginHibDao();
/**
 * An object of the SystemUsers bean class.
 * This object will be automatically populated by the Struts 2 framework based on the data captured by the data entry form.
 */
    private SystemUsers systemuser;
/**
 * A string to hold error message, if any, which will be displayed in JSP.
 */
    private String message;
/**
 * A map object to hold current session.
 */
    private Map session;

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
 * A getter method for the systemuser object of the SystemUsers bean class created earlier.
 * @return The SystemUsers object.
 */
    public SystemUsers getSystemuser() {
        return systemuser;
    }
/**
 * A setter method for the systemuser object of the SystemUsers bean class created earlier.
 * @param systemuser The SystemUsers object.
 */
    public void setSystemuser(SystemUsers systemuser) {
        this.systemuser = systemuser;
    }

/**
 * login() is invoked when the user keys in the login details and clicks login.
 * This method passes the login information to the DAO object's validateLogin() method, which validates and returns an object with the authenticated users data.
 * If the object holds user data then the same is added to the session.
 * If the object does not hold user data then an appropriate error message is send to JSP.
 * @throws java.lang.Exception
 */
    public String login() throws Exception {
        SystemUsers objSystemusers = (SystemUsers) loginService.validateLogin(systemuser.getUsername(), systemuser.getPassword());

        if(objSystemusers != null){
            session = ActionContext.getContext().getSession();
            session.put("username", systemuser.getUsername());
            session.put("authors", objSystemusers.getManageAuthors());
            session.put("books", objSystemusers.getManageBooks());
            session.put("categories", objSystemusers.getManageCategories());
            session.put("citystate", objSystemusers.getManageCityState());
            session.put("countries", objSystemusers.getManageCountries());
            session.put("customers", objSystemusers.getManageCustomers());
            session.put("publishers", objSystemusers.getManagePublishers());
            session.put("transactions", objSystemusers.getManageTransactions());
            session.put("users", objSystemusers.getManageUsers());
            return SUCCESS;
         }
        else {
            message = "Invalid Username or Password. Please try again";
            return ERROR;
        }
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
        session.clear();
        return SUCCESS;
    }
}