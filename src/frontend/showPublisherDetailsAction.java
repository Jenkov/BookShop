package frontend;

import beans.Publishers;
import beans.Books;
import frontend_dao.showPublisherDetailsHibDao;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

public class showPublisherDetailsAction extends ActionSupport{
/**
 * An object of the showPublisherDetailsHibDao class to display the publisher details.
 * The method will be invoked by the action class method.
 */
    private showPublisherDetailsHibDao publisherDetailsService = new showPublisherDetailsHibDao();
/**
 * An object of the Publishers bean class.
 */
    private Publishers publisher;
/**
 * A List type object of the Books bean class.
 * This List object will be populated by the viewPublisherBooks() method with the records available in the Books table.
 * This List object will be used to display existing records in the JSP page's data grid.
 */
    private List<Books> books;

/**
 * A getter method for the publisher object of the Publishers bean class created earlier.
 * @return The Publishers object.
 */
    public Publishers getPublisher() {
        return publisher;
    }
/**
 * A setter method for the publisher object of the Publishers bean class created earlier.
 * @param publisher The Publishers object.
 */
    public void setPublisher(Publishers publisher) {
        this.publisher = publisher;
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
 * viewPublisherBooks() method is invoked everytime the JSP page is served.
 * It populates the List object [publisher and book] created earlier which will be used in the JSP page's <s:iterator> tag.
 * This displays existing records from the Publishers and Books tables.
 * The data to be populated is retrieved using the DAO object's getAllPublishers() and getAllBooksOfThisPublisher() method.
 */
    public String viewPublisherBooks() throws Exception{
        publisher = publisherDetailsService.getAllPublishers(publisher.getPublisherNo());
        books = publisherDetailsService.getAllBooksOfThisPublisher(publisher.getPublisherNo());
        return SUCCESS;
    }
}