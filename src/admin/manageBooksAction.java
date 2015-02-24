package admin;

import admin_dao.BooksHibDao;
import admin_dao.PaginationHibDao;
import beans.Books;
import java.io.File;
import java.io.InputStream;
import com.opensymphony.xwork2.ActionSupport;
import common.populateDdlbs;
import java.io.FileInputStream;
import java.util.List;
import org.apache.struts2.interceptor.validation.SkipValidation;

public class manageBooksAction extends ActionSupport{
/**
 * An object of the BooksHibDao class to service data operation requests such as Insert, Update, Delete, View.
 * Methods of this object will be invoked to service these data operation requests.
 * These methods will be invoked by the action class methods.
 */
    private BooksHibDao booksService = new BooksHibDao();
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
 * An object of the Books bean class.
 * This object will be automatically populated by the Struts 2 framework based on the data captured by the data entry form.
 */
    private Books book;
/**
 * A List type object of the Books bean class.
 * This List object will be populated by the view() method with the records available in the Books table.
 * This List object will be used to display existing records in the JSP page's data grid.
 */
    private List<Books> books;
/**
 * Variable to hold the coverpage, TOC and sample chapter uploaded via the data entry form.
 */
    private File CoverPage, Toc, SampleChapter;
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
 * A getter method for the book object of the Books bean class created earlier.
 * @return The Books object.
 */
    public Books getBook() {
        return book;
    }
/**
 * A setter method for the book object of the Books bean class created earlier.
 * @param book The Books object.
 */
    public void setBook(Books book) {
        this.book = book;
    }

/**
 * A getter method for the List object of the Books bean class created earlier.
 * This list will be made available to the JSP page for displaying book details data grid.
 * @return A list object of Books.
 */
    public List<Books> getBooks() {
        return books;
    }
/**
 * A setter method for the List object of the Books bean class created earlier.
 * This list will be made available to the JSP page for displaying book details data grid.
 * @param books A list object of Books.
 */
    public void setBooks(List<Books> books) {
        this.books = books;
    }

/**
 * A getter method for the File object of the SampleChapter in the data entry form.
 * @return The file object.
 */
    public File getSampleChapter() {
        return SampleChapter;
    }
/**
 * A setter method for the File object of the SampleChapter in the data entry form.
 * @param SampleChapter The file object.
 */
    public void setSampleChapter(File SampleChapter) {
        this.SampleChapter = SampleChapter;
    }

/**
 * A getter method for the File object of the Toc in the data entry form.
 * @return The file object.
 */
    public File getToc() {
        return Toc;
    }
/**
 * A setter method for the File object of the Toc in the data entry form.
 * @param Toc The file object.
 */
    public void setToc(File Toc) {
        this.Toc = Toc;
    }

/**
 * A getter method for the File object of the CoverPage in the data entry form.
 * @return The file object.
 */
    public File getCoverPage() {
        return CoverPage;
    }
/**
 * A setter method for the File object of the CoverPage in the data entry form.
 * @param CoverPage The file object.
 */
    public void setCoverPage(File CoverPage) {
        this.CoverPage = CoverPage;
    }

/**
 * insertupdate() method is invoked when a user keys in the desired data and clicks Save.
 * It performs an update operation [using DAO object's update() method] if the book.BookNo holds a valid Book No.
 * It performs an insert operation [using DAO object's insert() method] if the book.BookNo is empty.
 * The captured form data is passed to the DAO object's methods using the parameterized constructor of the Books bean class.
 */
    public String insertupdate() throws Exception{
        File coverpageImage = null;
        InputStream iStreamCoverPage = null;

        if(CoverPage != null) {
            coverpageImage = new File(CoverPage.toString());
            iStreamCoverPage = new FileInputStream(CoverPage);
            book.setCoverPage(org.hibernate.Hibernate.createBlob(iStreamCoverPage));
        }

        File TocPDF = null;
        InputStream iStreamToc = null;

        if(Toc != null) {
            TocPDF = new File(Toc.toString());
            iStreamToc = new FileInputStream(Toc);
            book.setToc(org.hibernate.Hibernate.createBlob(iStreamToc));
        }

        File samplechapterPDF = null;
        InputStream iStreamSampleChapter = null;

        if(SampleChapter != null) {
            samplechapterPDF = new File(SampleChapter.toString());
            iStreamSampleChapter = new FileInputStream(SampleChapter);
            book.setSampleChapter(org.hibernate.Hibernate.createBlob(iStreamSampleChapter));
        }

        if(book.getBookNo()>0) {
            booksService.update(book);
        }
        else {
            booksService.insert(book);
        }

        return SUCCESS;
    }

/**
 * view() method is invoked everytime the JSP page is served.
 * It populates the List object [books] created earlier which will be used in the JSP page's <s:iterator> tag to form the data grid.
 * This data grid displays existing records from the Books table.
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
 * The delete operation is performed by invoking the DAO object's getBookNo() method.
 * getBookNo() method is passed the BookNo which is made available by the JSP page using <s:param> on click of X.
 * @SkipValidation is used to skip validation for this method.
 */
    @SkipValidation
    public String delete() throws Exception{
        booksService.delete(book.getBookNo());
        return SUCCESS;
    }

/**
 * edit() method is invoked when a user clicks a desired record from the data grid in the JSP page for updating it.
 * It populates the bean class object with the chosen record's data.
 * The data is retrieved using the DAO object's edit() method which is passed the chosen record's BookNo.
 * BookNo is made available by the JSP page's <s:param> tag on click of the record.
 * The Struts 2 framework automatically transfer the values from the bean class object to the form fields making it available to the user for update.
 * @SkipValidation is used to skip validation for this method.
 */
    @SkipValidation
    public String edit() throws Exception{
        book = booksService.edit(book.getBookNo());
        view();
        return SUCCESS;
    }

/**
 * getPage() method is invoked everytime the JSP page is served or the user clicks a page link from the JSP page using pagination.
 * It populates the List object [books] created earlier which will be used in the JSP page's <s:iterator> tag to form the data grid.
 * This data grid displays existing records from the Books table.
 * The data to be populated is retrieved using the DAO object's getPage() method which makes the required page available to the JSP.
 * @SkipValidation is used to skip validation for this method.
 */
    @SkipValidation
    public String getPage() throws Exception{
        pageCount = pg.getTotalPages("Books");
        books = pg.getPage(pageNo-1, "Books").getList();
        return SUCCESS;
    }
}