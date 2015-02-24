package frontend;

import beans.Authors;
import beans.Books;
import beans.Categories;
import beans.Publishers;
import frontend_dao.homeHibDao;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

public class homeAction  extends ActionSupport{
/**
 * An object of the homeHibDao class to display data such as the author name, publisher name, the category name, the book name.
 */
    private homeHibDao homeService = new homeHibDao();
/**
 * A List type object of the Books bean class.
 * This List object will be populated by the view() method with the records available in the Books table.
 * This List object will be used to display existing records in the JSP page.
 */
    private List<Books> books, newReleasesBooks, updatedBooks, topTitlesBooks;
/**
 * A List type object of the Authors bean class.
 * This List object will be populated by the view() method with the records available in the Authors table.
 * This List object will be used to display existing records in the JSP page.
 */
    private List<Authors> authors;
/**
 * A List type object of the Publishers bean class.
 * This List object will be populated by the view() method with the records available in the Publishers table.
 * This List object will be used to display existing records in the JSP page.
 */
    private List<Publishers> publishers;
/**
 * A List type object of the Categories bean class.
 * This List object will be populated by the view() method with the records available in the Categories table.
 * This List object will be used to display existing records in the JSP page.
 */
    private List<Categories> categories;
/**
 * Declaring a List for holding PopularSearches.
 * This List object will be populated by the getAllPopularSearches() method with the records available in the PopularSearches table.
 * This List will be returned to the view() method of the Action class which in turn will make it available the JSP page.
 * This List object will be used to display tag clouds in the home page.
 */
    private List popularSearches;
/**
 * A variable to hold the category identity number.
 */
    private int CategoryNo;

/**
 * A getter method for the category identity number.
 * This page number will be received as a parameter from the JSP page when a user clicks the desired link to view.
 * @return The category identity number.
 */
    public int getCategoryNo() {
        return CategoryNo;
    }
/**
 * A setter method for the category identity number.
 * This page number will be received as a parameter from the JSP page when a user clicks the desired link to view.
 * @param CategoryNo The category identity number.
 */
    public void setCategoryNo(int CategoryNo) {
        this.CategoryNo = CategoryNo;
    }

/**
 * A getter method for the popular searches.
 * @return The pouplar searches.
 */
    public List getPopularSearches() {
        return popularSearches;
    }
/**
 * A getter method for the popular searches.
 * @param popularSearches The pouplar searches.
 */
    public void setPopularSearches(List popularSearches) {
        this.popularSearches = popularSearches;
    }

/**
 * A getter method for the List object of the Books bean class created earlier.
 * This list will be made available to the JSP page for displaying book details.
 * @return A list object of Books.
 */
    public List<Books> getBooks() {
        return books;
    }
/**
 * A setter method for the List object of the Books bean class created earlier.
 * This list will be made available to the JSP page for displaying book details.
 * @param books A list object of Books.
 */
    public void setBooks(List<Books> books) {
        this.books = books;
    }

/**
 * A getter method for the List object of the Books bean class created earlier.
 * This list will be made available to the JSP page for displaying book details.
 * @return A list object of Books.
 */
    public List<Books> getNewReleasesBooks() {
        return newReleasesBooks;
    }
/**
 * A setter method for the List object of the Books bean class created earlier.
 * This list will be made available to the JSP page for displaying book details.
 * @param newReleasesBooks A list object of Books.
 */
    public void setNewReleasesBooks(List<Books> newReleasesBooks) {
        this.newReleasesBooks = newReleasesBooks;
    }

/**
 * A getter method for the List object of the Books bean class created earlier.
 * This list will be made available to the JSP page for displaying book details.
 * @return A list object of Books.
 */
    public List<Books> getUpdatedBooks() {
        return updatedBooks;
    }
/**
 * A setter method for the List object of the Books bean class created earlier.
 * This list will be made available to the JSP page for displaying book details.
 * @param updatedBooks A list object of Books.
 */
    public void setUpdatedBooks(List<Books> updatedBooks) {
        this.updatedBooks = updatedBooks;
    }

/**
 * A getter method for the List object of the Books bean class created earlier.
 * This list will be made available to the JSP page for displaying book details.
 * @return A list object of Books.
 */
    public List<Books> getTopTitlesBooks() {
        return topTitlesBooks;
    }
/**
 * A setter method for the List object of the Books bean class created earlier.
 * This list will be made available to the JSP page for displaying book details.
 * @param topTitlesBooks A list object of Books.
 */
    public void setTopTitlesBooks(List<Books> topTitlesBooks) {
        this.topTitlesBooks = topTitlesBooks;
    }

/**
 * A getter method for the List object of the Authors bean class created earlier.
 * This list will be made available to the JSP page for displaying author details.
 * @return A list object of Authors.
 */
    public List<Authors> getAuthors() {
        return authors;
    }
/**
 * A setter method for the List object of the Authors bean class created earlier.
 * This list will be made available to the JSP page for displaying author details.
 * @param authors A list object of Authors.
 */
    public void setAuthors(List<Authors> authors) {
        this.authors = authors;
    }

/**
 * A getter method for the List object of the Publishers bean class created earlier.
 * This list will be made available to the JSP page for displaying publisher details.
 * @return A list object of Publishers.
 */
    public List<Publishers> getPublishers() {
        return publishers;
    }
/**
 * A setter method for the List object of the Publishers bean class created earlier.
 * This list will be made available to the JSP page for displaying publisher details.
 * @param publishers A list object of Publishers.
 */
    public void setPublishers(List<Publishers> publishers) {
        this.publishers = publishers;
    }

/**
 * A getter method for the List object of the Categories bean class created earlier.
 * This list will be made available to the JSP page for displaying category details data grid.
 * @return A list object of Categories.
 */
    public List<Categories> getCategories() {
        return categories;
    }
/**
 * A setter method for the List object of the Categories bean class created earlier.
 * This list will be made available to the JSP page for displaying category details data grid.
 * @param categories A list object of Categories.
 */
    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

/**
 * viewBooksForThisCategory() method is invoked everytime the JSP page is served.
 * It populates the List object [books] created earlier which will be used in the JSP page's <s:iterator> tag to form the data grid.
 * This data grid displays existing records from the Books table.
 * The data to be populated is retrieved using the DAO object's getAllBooksForThisCategory() method.
 */
    public String viewBooksForThisCategory() throws Exception{
        books = homeService.getAllBooksForThisCategory(CategoryNo);
        return SUCCESS;
    }

/**
 * view() method is invoked everytime the JSP page is served.
 * It populates the List objects created earlier which will be used in the JSP page's <s:iterator> tag.
 * This data grid displays existing records from the Authors, Books, Categories and Publishers table.
 * The data to be populated is retrieved using the DAO object's methods.
 */
    public String view() throws Exception{
        newReleasesBooks = homeService.getAllNewReleases();
        authors = homeService.getAllShowAuthors();
        publishers = homeService.getAllShowPublishers();
        updatedBooks = homeService.getAllUpdatedBooks();
        topTitlesBooks = homeService.getAllTopTitles();
        categories = homeService.getAllCategories();
        popularSearches = homeService.getAllPopularSearches();
        return SUCCESS;
    }
}