package frontend_dao;

import beans.Publishers;
import common.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class showPublisherDetailsHibDao {
/**
 * getAllPublishers() method is invoked by the viewPublisherBooks() method of the Action class to view the details of Authors in the JSP page when the user clicks on the Publisher name in the Home page.
 * This method receives PublisherNo which is used as the WHERE clause criteria.
 * It queries the database to retrieve the chosen record's data to return to the viewPublisherBooks() method for populating the JSP page.
 * To prevent any kinds of errors, uniqueResult() is applied which ensures that only unique record is retrived.
 */
    public Publishers getAllPublishers(int PublisherNo) {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM Publishers WHERE PublisherNo = :PublisherNo");
            query.setInteger("PublisherNo", PublisherNo);
            return (Publishers) query.uniqueResult();
        }
        finally {
            session.close();
        }
    }

/**
 * getAllBooksOfThisPublisher() method is invoked by the Action class's viewPublisherBooks() method everytime the user clicks the Publisher name in the Homepage to view the book details published by that particular publisher.
 * It retrieves [using createQuery()], populates the List object and returns the same to the viewPublisherBooks() method.
 * This List will be used in the JSP page's <s:iterator> tag to form the data grid.
 * This data grid displays existing records from the Books table.
 */
    public List getAllBooksOfThisPublisher(int PublisherNo) {
        Session session = HibernateUtil.getSession();

        try {
            Query query = session.createQuery("FROM Books WHERE PublisherNo = :PublisherNo");
            query.setInteger("PublisherNo", PublisherNo);
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