package admin;

import admin_dao.AuthorsHibDao;
import admin_dao.PaginationHibDao;
import beans.Authors;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import com.opensymphony.xwork2.ActionSupport;
import common.populateDdlbs;
import org.apache.struts2.interceptor.validation.SkipValidation;

public class manageAuthorsAction extends ActionSupport{
/**
 * An object of the AuthorsHibDao class to service data operation requests such as Insert, Update, Delete, View.
 * Methods of this object will be invoked to service these data operation requests.
 * These methods will be invoked by the action class methods.
 */
    private AuthorsHibDao authorsService = new AuthorsHibDao();
/**
 * An object of the populateDdlbs class to service data operation requests such as Populating DDLBs.
 */
    private populateDdlbs ddlb = new populateDdlbs();
/**
 * An object of the PaginationHibDao class to service data operation requests such as Pagination.
 * Methods of this object will be invoked to service pagination requests.
 * These methods will be invoked by the action class methods.
 */
    private PaginationHibDao pg = new PaginationHibDao();
/**
 * An object of the Authors bean class.
 * This object will be automatically populated by the Struts 2 framework based on the data captured by the data entry form.
 */
    private Authors author;
/**
 * A List type object of the Authors bean class.
 * This List object will be populated by the view() method with the records available in the Authors table.
 * This List object will be used to display existing records in the JSP page's data grid.
 */
    private List<Authors> authors;
/**
 * A variable to hold the photograph uploaded via the data entry form.
 */
    private File Photograph;
/**
 * Variable to hold the pagination parameters.
 */
    private int pageNo, pageCount;

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
 * A getter method for the author object of the Authors bean class created earlier.
 * @return The Authors object.
 */
    public Authors getAuthor() {
        return author;
    }
/**
 * A setter method for the author object of the Authors bean class created earlier.
 * @param author The Authors object.
 */
    public void setAuthor(Authors author) {
        this.author = author;
    }

/**
 * A getter method for the List object of the Authors bean class created earlier.
 * This list will be made available to the JSP page for displaying author details data grid.
 * @return A list object of Authors.
 */
    public List<Authors> getAuthors() {
        return authors;
    }
/**
 * A setter method for the List object of the Authors bean class created earlier.
 * This list will be made available to the JSP page for displaying author details data grid.
 * @param authors A list object of Authors.
 */
    public void setAuthors(List<Authors> authors) {
        this.authors = authors;
    }

/**
 * A getter method for the File object of the Photograph in the data entry form.
 * @return The file object.
 */
    public File getPhotograph(){
        return Photograph;
    }
/**
 * A setter method for the File object of the Photograph in the data entry form.
 * @param Photograph The file object.
 */
    public void setPhotograph(File Photograph){
        this.Photograph = Photograph;
    }

/**
 * insertupdate() method is invoked when a user keys in the desired data and clicks Save.
 * It performs an update operation [using DAO object's update() method] if the author.AuthorNo holds a valid Author No.
 * It performs an insert operation [using DAO object's insert() method] if the author.AuthorNo is empty.
 * The captured form data is passed to the DAO object's methods using the parameterized constructor of the Authors bean class.
 */
    public String insertupdate() throws Exception{
        File photographImage = null;
        InputStream iStreamPhotograph = null;

        if(Photograph != null) {
            photographImage = new File(Photograph.toString());
            iStreamPhotograph = new FileInputStream(Photograph);
            author.setPhotograph(org.hibernate.Hibernate.createBlob(iStreamPhotograph));
        }

        if(author.getAuthorNo()>0) {
            authorsService.update(author);
        }
        else {
            authorsService.insert(author);
        }
        return SUCCESS;
    }

/**
 * view() method is invoked everytime the JSP page is served.
 * It populates the List object [authors] created earlier which will be used in the JSP page's <s:iterator> tag to form the data grid.
 * This data grid displays existing records from the Authors table.
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
 * The delete operation is performed by invoking the DAO object's getAuthorNo() method.
 * getAuthorNo() method is passed the AuthorNo which is made available by the JSP page using <s:param> on click of X.
 * @SkipValidation is used to skip validation for this method.
 */
    @SkipValidation
    public String delete() throws Exception{
        try{
            authorsService.delete(author.getAuthorNo());
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
 * The data is retrieved using the DAO object's edit() method which is passed the chosen record's AuthorNo.
 * AuthorNo is made available by the JSP page's <s:param> tag on click of the record.
 * The Struts 2 framework automatically transfer the values from the bean class object to the form fields making it available to the user for update.
 * @SkipValidation is used to skip validation for this method.
 */
    @SkipValidation
    public String edit() throws Exception{
        author = authorsService.edit(author.getAuthorNo());
        view();
        return SUCCESS;
    }

/**
 * getPage() method is invoked everytime the JSP page is served or the user clicks a page link from the JSP page using pagination.
 * It populates the List object [authors] created earlier which will be used in the JSP page's <s:iterator> tag to form the data grid.
 * This data grid displays existing records from the Authors table.
 * The data to be populated is retrieved using the DAO object's getPage() method which makes the required page available to the JSP.
 * @SkipValidation is used to skip validation for this method.
 */
    @SkipValidation
    public String getPage() throws Exception{
        pageCount = pg.getTotalPages("Authors");
        authors = pg.getPage(pageNo-1, "Authors").getList();
        return SUCCESS;
    }
}