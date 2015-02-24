package frontend;

import beans.Books;
import frontend_dao.showBookDetailsHibDao;
import com.opensymphony.xwork2.ActionSupport;

public class showBookDetailsAction extends ActionSupport{
/**
 * An object of the showBookDetailsHibDao class to display the book details.
 * This method will be invoked by the action class method.
 */
    private showBookDetailsHibDao bookDetailsService = new showBookDetailsHibDao();
/**
 * An object of the Books bean class.
 */
    private Books book;

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
 * viewBooks() method is invoked everytime the JSP page is served.
 * It populates the List object [book] created earlier.
 * This displays existing records from the Books table.
 * The data to be populated is retrieved using the DAO object's getAllBooks() method.
 */
    public String viewBooks() throws Exception{
        book = bookDetailsService.getAllBooks(book.getBookNo());
        return SUCCESS;
    }
}