package frontend_dao;

import beans.Authors;
import common.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class showAuthorDetailsHibDao {
/**
 * getAllAuthors() method is invoked by the viewAuthorBooks() method of the Action class to view the details of Authors in the JSP page when the user clicks on the Author name in the Home page.
 * This method receives AuthorNo which is used as the WHERE clause criteria.
 * It queries the database to retrieve the chosen record's data to return to the viewAuthorBooks() method for populating the JSP page.
 * To prevent any kinds of errors, uniqueResult() is applied which ensures that only unique record is retrived.
 */
    public Authors getAllAuthors(int AuthorNo) {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM Authors WHERE AuthorNo = :AuthorNo");
            query.setInteger("AuthorNo", AuthorNo);
            return (Authors) query.uniqueResult();
        }
        finally {
            session.close();
        }
    }

/**
 * getAllBooksOfThisAuthor() method is invoked by the Action class's viewAuthorBooks() method everytime the user clicks the Author name in the Homepage to view the book details written by that particular author.
 * It retrieves [using createQuery()], populates the List object and returns the same to the viewAuthorBooks() method.
 * This List will be used in the JSP page's <s:iterator> tag to form the data grid.
 * This data grid displays existing records from the Books table.
 */
    public List getAllBooksOfThisAuthor(int AuthorNo) {
        Session session = HibernateUtil.getSession();

        try {
            Query query = session.createQuery("FROM Books WHERE Author1No = :AuthorNo OR Author2No = :AuthorNo OR Author3No = :AuthorNo OR Author4No = :AuthorNo");
            query.setInteger("AuthorNo", AuthorNo);
            return query.list();
        }
        catch(Exception e) {
            System.out.print("Error while fetching" + e);
            return null;
        }
        finally {
            session.close();
        }
    }
}