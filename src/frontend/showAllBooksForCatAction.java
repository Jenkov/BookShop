package frontend;

import beans.Categories;
import beans.Books;
import java.util.List;
import frontend_dao.showAllBooksForCatHibDao;
import com.opensymphony.xwork2.ActionSupport;

public class showAllBooksForCatAction extends ActionSupport{
/**
 * An object of the showAllBooksForCatHibDao class to display the category and book details.
 * This method will be invoked by the action class method.
 */
    private showAllBooksForCatHibDao booksForCatService = new showAllBooksForCatHibDao();
/**
 * An object of the Categories bean class.
 */
    private Categories category;
/**
 * A List type object of the Books bean class.
 * This List object will be populated by the viewCategoryBooks() method with the records available in the Books table.
 * This List object will be used to display existing records in the JSP page's data grid.
 */
    private List<Books> books;

/**
 * A getter method for the category object of the Categories bean class created earlier.
 * @return The Categories object.
 */
    public Categories getCategory() {
        return category;
    }
/**
 * A setter method for the category object of the Categories bean class created earlier.
 * @param category The Categories object.
 */
    public void setCategory(Categories category) {
        this.category = category;
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
 * viewCategoryBooks() method is invoked everytime the JSP page is served.
 * It populates the List object [category and books] created earlier which will be used in the JSP page's <s:iterator> tag.
 * This displays existing records from the Categories and Books table.
 * The data to be populated is retrieved using the DAO object's getAllCategories() and getAllBooksOfThisCategory() methods.
 */
    public String viewCategoryBooks() throws Exception{
        category = booksForCatService.getAllCategories(category.getCategoryNo());
        books = booksForCatService.getAllBooksOfThisCategory(category.getCategoryNo());
        return SUCCESS;
    }
}