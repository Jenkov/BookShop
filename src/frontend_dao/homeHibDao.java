package frontend_dao;

import beans.PopularSearches;
import java.util.List;
import common.HibernateUtil;
import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class homeHibDao {
/**
 * getAllNewReleases() method is invoked by the Action class's view() method everytime the JSP page is served.
 * It retrieves [using createQuery()], populates the List object and returns the same to the view() method.
 * This List will be used in the JSP page's <s:iterator> tag to display existing records from the Books table.
 */
    public List getAllNewReleases() {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            return session.createQuery("FROM Books ORDER BY Year DESC").setMaxResults(10).list();
        }
        catch(Exception e) {
            System.out.print("Error while fetching" + e);
            return null;
        }
        finally {
            session.close();
        }
    }

/**
 * getAllShowAuthors() method is invoked by the Action class's view() method everytime the JSP page is served.
 * It retrieves [using createQuery()], populates the List object and returns the same to the view() method.
 * This List will be used in the JSP page's <s:iterator> tag to display existing records from the Authors table.
 */
    public List getAllShowAuthors() {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            return session.createQuery("FROM Authors").setMaxResults(10).list();
        }
        catch(Exception e) {
            System.out.print("Error while fetching" + e);
            return null;
        }
        finally {
            session.close();
        }
    }

/**
 * getAllShowPublishers() method is invoked by the Action class's view() method everytime the JSP page is served.
 * It retrieves [using createQuery()], populates the List object and returns the same to the view() method.
 * This List will be used in the JSP page's <s:iterator> tag to display existing records from the Publishers table.
 */
    public List getAllShowPublishers() {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            return session.createQuery("FROM Publishers").setMaxResults(10).list();
        }
        catch(Exception e) {
            System.out.print("Error while fetching" + e);
            return null;
        }
        finally {
            session.close();
        }
    }

/**
 * getAllUpdatedBooks() method is invoked by the Action class's view() method everytime the JSP page is served.
 * It retrieves [using createQuery()], populates the List object and returns the same to the view() method.
 * This List will be used in the JSP page's <s:iterator> tag to display existing records from the Books table.
 */
    public List getAllUpdatedBooks() {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            return session.createQuery("FROM Books WHERE Edition <> 'First' ORDER BY Year DESC").setMaxResults(10).list();
        }
        catch(Exception e) {
            System.out.print("Error while fetching" + e);
            return null;
        }
        finally {
            session.close();
        }
    }

/**
 * getAllTopTitle() method is invoked by the Action class's view() method everytime the JSP page is served.
 * It retrieves [using createQuery()], populates the List object and returns the same to the view() method.
 * This List will be used in the JSP page's <s:iterator> tag to display existing records from the Books table.
 */
    public List getAllTopTitles() {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            return session.createQuery("FROM Books ORDER BY Hits DESC").setMaxResults(10).list();
        }
        catch(Exception e) {
            System.out.print("Error while fetching" + e);
            return null;
        }
        finally {
            session.close();
        }
    }

/**
 * getAllCategories() method is invoked by the Action class's view() method everytime the JSP page is served.
 * It retrieves [using createQuery()], populates the List object and returns the same to the view() method.
 * This List will be used in the JSP page's <s:iterator> tag to display existing records from the Categories table.
 */
    public List getAllCategories() {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            return session.createQuery("FROM Categories ORDER BY Category").list();
        }
        catch(Exception e) {
            System.out.print("Error while fetching" + e);
            return null;
        }
        finally {
            session.close();
        }
    }

/**
 * getAllBooksForThisCategory() method is invoked by the Action class's viewBooksForThisCategory() method everytime the JSP page is served.
 * It retrieves [using createQuery()], populates the List object and returns the same to the viewBooksForThisCategory() method.
 * This List will be used in the JSP page's <s:iterator> tag to display existing records from the Books table.
 */
    public List getAllBooksForThisCategory(int CategoryNo) {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            return session.createQuery("FROM Books WHERE CategoryNo = :CategoryNo").setInteger("CategoryNo", CategoryNo).setMaxResults(3).list();
        }
        catch(Exception e) {
            System.out.print("Error while fetching" + e);
            return null;
        }
        finally {
            session.close();
        }
    }

/**
 * getAllPopularSearches() method is invoked by the Action class's view() method everytime the JSP page is served.
 * It retrieves [using createSQLQuery()], populates the List object and returns the same to the view() method.
 * This List will be used in the JSP page's <s:iterator> tag to display existing records from the PopularSearches table.
*/
    public List getAllPopularSearches() {
        Session session = HibernateUtil.getSession();

        try {
            deletePopularSearches();
            session.beginTransaction();
            return session.createSQLQuery("SELECT Criteria, Value, COUNT(*) AS Weight FROM PopularSearches GROUP BY Criteria, Value").list();
        }
        catch(Exception e) {
            System.out.print("Error while fetching" + e);
            return null;
        }
        finally {
            session.close();
        }
    }

/**
 * getTotalPopularSearches() is invoked by the deletePopularSearches() method.
 * This method retrieves the total number of records available in the PopularSearches table.
 */
    public int getTotalPopularSearches(){
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            Object TransactionNo = session.createSQLQuery("SELECT COUNT(*) AS Total FROM PopularSearches").addScalar("Total").uniqueResult();
            return Integer.parseInt(TransactionNo.toString());
        }
        finally {
            session.close();
        }
    }

/**
 * deletePopularSearches() method is invoked by the getAllPopularSearches() method.
 * This method checks whether the total number of records in the PopularSearches table crosses the limit of 600.
 * If the PopularSearches table holds more than 600 records, then this method will delete the 10 records from the PopularSearches table.
 */
    public void deletePopularSearches() {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            if(getTotalPopularSearches()>600) {
                session.beginTransaction();
                List<PopularSearches> ps = session.createQuery("FROM PopularSearches").setMaxResults(10).list();

                for (Iterator i = ps.iterator(); i.hasNext();) {
                    tx = session.beginTransaction();
                    Object objPs = i.next();
                    session.delete(objPs);
                    tx.commit();
                }
            }
        }
        catch(Exception e) {
            System.out.print("Error while deleting" + e);
        }
        finally {
            session.close();
        }
    }
}