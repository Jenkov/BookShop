package admin;

import admin_dao.CityStateHibDao;
import admin_dao.PaginationHibDao;
import beans.CityState;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.validation.SkipValidation;

public class manageCitiesStatesAction extends ActionSupport{
/**
 * An object of the CityStateHibDao class to service data operation requests such as Insert, Update, Delete, View.
 * Methods of this object will be invoked to service these data operation requests.
 * These methods will be invoked by the action class methods.
 */
    private CityStateHibDao citystateService = new CityStateHibDao();
/**
 * An object of the PaginationHibDao class to service data operation requests such as Pagination.
 * Methods of this object will be invoked to service pagination requests.
 * These methods will be invoked by the action class methods.
 */
    private PaginationHibDao pg = new PaginationHibDao();
/**
 * An object of the CityState bean class.
 * This object will be automatically populated by the Struts 2 framework based on the data captured by the data entry form.
 */
    private CityState citystate;
/**
 * A List type object of the CityState bean class.
 * This List object will be populated by the view() method with the records available in the CityState table.
 * This List object will be used to display existing records in the JSP page's data grid.
 */
    private List<CityState> citiesstates;
/**
 * Variable to hold the pagination parameters.
 */
    private int pageNo, pageCount;

/**
 * A getter method for the current page number.
 * This page number will be received as a parameter from the JSP page when a user clicks the desired page to view.
 * @return The current page number.
 */
    public int getPageNo() {
        return pageNo;
    }
/**
 * A setter method for the current page number.
 * This page number will be received as a parameter from the JSP page when a user clicks the desired page to view.
 * @param pageNo The current page number.
 */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

/**
 * A getter method for the page count which holds the total number of pages based on the total number of records.
 * This page count can be used to create the page link in the JSP page.
 * @return The page count.
 */
    public int getPageCount() {
        return pageCount;
    }
/**
 * A setter method for the page count which holds the total number of pages based on the total number of records.
 * This page count can be used to create the page link in the JSP page.
 * @param pageCount The page count.
 */
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

/**
 * A getter method for the citystate object of the CityState bean class created earlier.
 * @return The CityState object.
 */
    public CityState getCitystate() {
        return citystate;
    }
/**
 * A setter method for the citystate object of the CityState bean class created earlier.
 * @param citystate The CityState object.
 */
    public void setCitystate(CityState citystate) {
        this.citystate = citystate;
    }

/**
 * A getter method for the List object of the CityState bean class created earlier.
 * This list will be made available to the JSP page for displaying city/state details data grid.
 * @return A list object of CityState.
 */
    public List<CityState> getCitiesstates() {
        return citiesstates;
    }
/**
 * A setter method for the List object of the CityState bean class created earlier.
 * This list will be made available to the JSP page for displaying city/state details data grid.
 * @param citiesstates A list object of CityState.
 */
    public void setCitiesstates(List<CityState> citiesstates) {
        this.citiesstates = citiesstates;
    }

/**
 * insertupdate() method is invoked when a user keys in the desired data and clicks Save.
 * It performs an update operation [using DAO object's update() method] if the citystate.getCityStateNo holds a valid CityState No.
 * It performs an insert operation [using DAO object's insert() method] if the citystate.getCityStateNo is empty.
 * The captured form data is passed to the DAO object's methods using the parameterized constructor of the CityState bean class.
 */
    public String insertupdate() throws Exception{
        if(citystate.getCityStateNo()>0) {
            citystateService.update(citystate);
        }
        else {
            citystateService.insert(citystate);
        }
        return SUCCESS;
    }

/**
 * view() method is invoked everytime the JSP page is served.
 * It populates the List object [citiesstates] created earlier which will be used in the JSP page's <s:iterator> tag to form the data grid.
 * This data grid displays existing records from the CityState table.
 * The data to be populated is retrieved using the DAO object's getPage() method which makes the first page available to the JSP.
 * @SkipValidation is used to skip validation for this method.
 */
    @SkipValidation
    public String view() throws Exception{
        pageNo = 1;
        getPage();
        return SUCCESS;
    }

/**
 * delete() method is invoked when a user clicks X adjacent to the desired record for deletion.
 * The delete operation is performed by invoking the DAO object's getCityStateNo() method.
 * getCityStateNo() method is passed the CityStateNo which is made available by the JSP page using <s:param> on click of X.
 * @SkipValidation is used to skip validation for this method.
 */
    @SkipValidation
    public String delete() throws Exception{
        try{
            citystateService.delete(citystate.getCityStateNo());
        }
        catch(Exception e) {
            addActionError(e.getCause().toString().split("[:]")[1]);
            return ERROR;
        }
        return SUCCESS;
    }

/**
 * edit() method is invoked when a user clicks a desired record from the data grid in the JSP page for updating it.
 * It populates the bean class object with the chosen record's data.
 * The data is retrieved using the DAO object's edit() method which is passed the chosen record's CityStateNo.
 * CityStateNo is made available by the JSP page's <s:param> tag on click of the record.
 * The Struts 2 framework automatically transfer the values from the bean class object to the form fields making it available to the user for update.
 * @SkipValidation is used to skip validation for this method.
 */
    @SkipValidation
    public String edit() throws Exception{
        citystate = citystateService.edit(citystate.getCityStateNo());
        view();
        return SUCCESS;
    }

/**
 * getPage() method is invoked everytime the JSP page is served or the user clicks a page link from the JSP page using pagination.
 * It populates the List object [citiesstates] created earlier which will be used in the JSP page's <s:iterator> tag to form the data grid.
 * This data grid displays existing records from the CityState table.
 * The data to be populated is retrieved using the DAO object's getPage() method which makes the required page available to the JSP.
 * @SkipValidation is used to skip validation for this method.
 */
    @SkipValidation
    public String getPage() throws Exception{
        pageCount = pg.getTotalPages("CityState");
        citiesstates = pg.getPage(pageNo-1, "CityState").getList();
        return SUCCESS;
    }
}