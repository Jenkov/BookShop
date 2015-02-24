package frontend_dao;

import beans.Customers;
import common.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class customerLoginHibDao {
/**
 * validateLogin() method is invoked by the login() method of the Action class to authenticate Customers.
 * This method receives Username and Password which is used as the WHERE clause criteria.
 * It queries the database to retrieve the chosen record's data to return to the login() method.
 * @param Username The Username.
 * @param Password The Password.
*/
    public Object validateLogin(String Username, String Password, String LastIP) {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM Customers WHERE Username = :Username AND Password = :Password");
            query.setString("Username", Username);
            query.setString("Password", Password);
            Customers objCustomer = (Customers) query.uniqueResult();

            if(objCustomer != null) {
                objCustomer.setLastIP(LastIP);
                objCustomer.setLastLogin((new java.util.Date().toString()));
                updateLastLoginDetails(objCustomer);
            }
            return objCustomer;
        }
        finally {
            session.close();
        }
    }

/**
 * updateLastLoginDetails() method is invoked by the validateLogin() method.
 * It performs an update operation [using update()].
 * The modified customer data is passed to this method.
 * @param objCustomers An object of the Customers class.
 */
    public void updateLastLoginDetails(Customers objCustomers) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(objCustomers);
            tx.commit();
        }
        catch (RuntimeException e) {
            if(objCustomers != null)
                tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }

/**
 * getPassword() method is invoked by the retrievePassword() method of the Action class to retrieve the forgotten password.
 * This method receives Username and Email Address which is used as the WHERE clause criteria.
 * It queries the database to retrieve the chosen record's data to return to the retrievePassword() method.
 * @param Username The Username.
 * @param EmailAddress The Email Address.
*/
	public Object getPassword(String Username, String EmailAddress) {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM Customers WHERE Username = :Username AND EmailAddress = :EmailAddress");
            query.setString("Username", Username);
            query.setString("EmailAddress", EmailAddress);
            return query.uniqueResult();
        }
        finally {
            session.close();
        }
    }
}