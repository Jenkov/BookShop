package admin_dao;

import common.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class TransactionsHibDao {
/**
 * getAllUsernames() method is invoked by the Action class's populateUsernames() method everytime the JSP page is served.
 * It retrieves [using createQuery()], populates the List object [customers] created earlier and returns the same to the populateUsernames() method.
 * This List will be used in the JSP page's drop down list box.
 * This drop down list box displays existing records from the Customers table.
 */
    public List getAllUsernames() {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            return session.createQuery("FROM Customers").list();
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
 * getAllEntries() method is invoked by the Action class's view() method.
 * It retrieves [using createQuery()], populates the List object [transactions] created earlier and returns the same to the view() method.
 * This List will be used in the JSP page's <s:iterator> tag to form the data grid.
 * This data grid displays existing records from the Transactions table.
*/
    public List getAllEntries(String username) {
        Session session = HibernateUtil.getSession();

        try {
            Query query = session.createQuery("FROM Transactions WHERE Username = :Username");
            query.setString("Username", username);
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