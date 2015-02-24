package frontend;

import beans.Authors;
import beans.Books;
import frontend_dao.showAuthorDetailsHibDao;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

public class showAuthorDetailsAction extends ActionSupport{
/**
 * An object of the showAuthorDetailsHibDao class to display the author details.
 * The method will be invoked by the action class method.
 */
    private showAuthorDetailsHibDao authorDetailsService = new showAuthorDetailsHibDao();
/**
 * An object of the Authors bean class.
 */
    private Authors author;
/**
 * A List type object of the Books bean class.
 * This List object will be populated by the viewAuthorBooks() method with the records available in the Books table.
 * This List object will be used to display existing records in the JSP page's data grid.
 */
    private List<Books> books;

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
 * viewAuthorBooks() method is invoked everytime the JSP page is served.
 * It populates the List object [author and book] created earlier which will be used in the JSP page's <s:iterator> tag.
 * This displays existing records from the Authors and Books tables.
 * The data to be populated is retrieved using the DAO object's getAllAuthors() and getAllBooksOfThisAuthor() method.
 */
    public String viewAuthorBooks() throws Exception{
        author = authorDetailsService.getAllAuthors(author.getAuthorNo());
        books = authorDetailsService.getAllBooksOfThisAuthor(author.getAuthorNo());
        return SUCCESS;
    }
}