package frontend;

import beans.Authors;
import beans.Books;
import beans.Publishers;
import frontend_dao.SearchResultsHibDao;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

public class SearchResultsAction extends ActionSupport{
/**
 * An object of the SearchResultsHibDao class to the data based on the keywords searched for.
 * Methods of this object will be invoked to service these data operation requests.
 * These methods will be invoked by the action class methods.
 */
    private SearchResultsHibDao SearchResultsService = new SearchResultsHibDao();
/**
 * An object of the Authors bean class.
 * This object will be automatically populated by the Struts 2 framework based on the data captured by the data entry form.
 */
    private Authors author;
/**
 * An object of the Publishers bean class.
 * This object will be automatically populated by the Struts 2 framework based on the data captured by the data entry form.
 */
    private Publishers publisher;
/**
 * List type objects of the Books bean class.
 * These List objects will be populated by the viewBooksSearchResults(), viewBooksOfThisAuthor() and viewBooksOfThisPublisher() method with the records available in the Books table.
 * These List objects will be used to display existing records in the JSP page.
 */
    private List<Books> books, authoredBooks, publishedBooks;
/**
 * A List type object of the Authors bean class.
 * This List object will be populated by the viewAuthorsSearchResults() method with the records available in the Authors table.
 * This List object will be used to display existing records in the JSP page.
 */
    private List<Authors> authors;
/**
 * A List type object of the Publishers bean class.
 * This List object will be populated by the viewPublishersSearchResults() method with the records available in the Publishers table.
 * This List object will be used to display existing records in the JSP page.
 */
    private List<Publishers> publishers;
/**
 * Variables to hold the search parameters.
 */
    private String SearchCriteria, searchType;

/**
 * A getter method for the search criteria.
 * This search criteria will be received as a parameter from the JSP page when a user clicks the desired button to view the details.
 * @return The search criteria.
 */
    public String getSearchCriteria() {
        return SearchCriteria;
    }
/**
 * A setter method for the search criteria.
 * This search criteria will be received as a parameter from the JSP page when a user clicks the desired button to view the details.
 * @param SearchCriteria The search criteria.
 */
    public void setSearchCriteria(String SearchCriteria) {
        this.SearchCriteria = SearchCriteria;
    }

/**
 * A getter method for the type of search made by the user.
 * This search type will be received as a parameter from the JSP page when a user clicks the desired button such as Book, Author and Publisher.
 * @return The search type.
 */
    public String getSearchType() {
        return searchType;
    }
/**
 * A setter method for the type of search made by the user.
 * This page number will be received as a parameter from the JSP page when a user clicks the desired button such as Book, Author and Publisher.
 * @param searchType The search type.
 */
    public void setSearchType(String searchType) {
        this.searchType = searchType;
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
 * This list will be made available to the JSP page for displaying book details data grid.
 * @return A list object of Books.
 */
    public List<Books> getAuthoredBooks() {
        return authoredBooks;
    }
/**
 * A setter method for the List object of the Books bean class created earlier.
 * This list will be made available to the JSP page for displaying book details data grid.
 * @param authoredBooks A list object of Books.
 */
    public void setAuthoredBooks(List<Books> authoredBooks) {
        this.authoredBooks = authoredBooks;
    }

/**
 * A getter method for the List object of the Books bean class created earlier.
 * This list will be made available to the JSP page for displaying book details data grid.
 * @return A list object of Books.
 */
    public List<Books> getPublishedBooks() {
        return publishedBooks;
    }
/**
 * A setter method for the List object of the Books bean class created earlier.
 * This list will be made available to the JSP page for displaying book details data grid.
 * @param publishedBooks A list object of Books.
 */
    public void setPublishedBooks(List<Books> publishedBooks) {
        this.publishedBooks = publishedBooks;
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
 * viewBooksSearchResults() method is invoked when the user clicks the Book button in the Home page or the search page.
 * It populates the List object [books] created earlier which will be used in the JSP page's <s:iterator> tag.
 * The JSP page displays existing records from the Books table.
 * The data to be populated is retrieved using the DAO object's getAllBooksSearchResults() method.
 */
    public String viewBooksSearchResults() throws Exception{
        books = SearchResultsService.getAllBooksSearchResults(SearchCriteria);
        return SUCCESS;
    }

/**
 * viewAuthorsSearchResults() method is invoked when the user clicks the Author button in the Home page or the search page.
 * It populates the List object [authors] created earlier which will be used in the JSP page's <s:iterator> tag.
 * The JSP page displays existing records from the Authors table.
 * The data to be populated is retrieved using the DAO object's getAllAuthorsSearchResults() method.
 */
    public String viewAuthorsSearchResults() throws Exception{
        authors = SearchResultsService.getAllAuthorsSearchResults(SearchCriteria);
        return SUCCESS;
    }

/**
 * viewBooksOfThisAuthor() method is invoked when the user clicks the Author button in the Home page or the search page.
 * It populates the List object [authoredBooks] created earlier which will be used in the JSP page's <s:iterator> tag to form the data grid.
 * This data grid displays existing records from the Books table.
 * The data to be populated is retrieved using the DAO object's getAllBooksOfThisAuthor() method which makes the first page available to the JSP.
 */
    public String viewBooksOfThisAuthor() throws Exception{
        authoredBooks = SearchResultsService.getAllBooksOfThisAuthor(author.getAuthorNo());
        return SUCCESS;
    }

/**
 * viewPublishersSearchResults() method is invoked when the user clicks the Publisher button in the Home page or the search page.
 * It populates the List object [publishers] created earlier which will be used in the JSP page's <s:iterator> tag.
 * The JSP page displays existing records from the Publishers table.
 * The data to be populated is retrieved using the DAO object's getAllPublishersSearchResults() method.
 */
    public String viewPublishersSearchResults() throws Exception{
        publishers = SearchResultsService.getAllPublishersSearchResults(SearchCriteria);
        return SUCCESS;
    }

/**
 * viewBooksOfThisPublisher() method is invoked when the user clicks the Publisher button in the Home page or the search page.
 * It populates the List object [publishedBooks] created earlier which will be used in the JSP page's <s:iterator> tag to form the data grid.
 * This data grid displays existing records from the Publishers table.
 * The data to be populated is retrieved using the DAO object's getAllBooksOfThisPublisher() method which makes the first page available to the JSP.
 */
    public String viewBooksOfThisPublisher() throws Exception{
        publishedBooks = SearchResultsService.getAllBooksOfThisPublisher(publisher.getPublisherNo());
        return SUCCESS;
    }

/**
 * performPopularSearch() is invoked whenever the link in the home page under the Popular Searches is clicked.
 * If the search type is book then the viewBooksSearchResults() method is invoked.
 * If the search type is author then the viewAuthorsSearchResults() method is invoked.
 * If the search type is publisher then the viewPublishersSearchResults() method is invoked.
 * @throws java.lang.Exception
 */
    public String performPopularSearch() throws Exception{
        if(searchType.equals("author")) {
            viewAuthorsSearchResults();
        }
        else if(searchType.equals("book")){
            viewBooksSearchResults();
        }
        else if(searchType.equals("publisher")){
            viewPublishersSearchResults();
        }
        return SUCCESS;
    }
}