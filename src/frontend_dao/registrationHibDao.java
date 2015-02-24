package frontend_dao;

import beans.Customers;
import common.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class registrationHibDao {
/**
 * insert() method is invoked by the insert() method of the Action class when a user keys in the desired data and clicks Save.
 * It performs an insert operation [using save()].
 * The captured form data is passed to the save() method which is made available by the insert() method as a method parameter.
 * @param objCustomers An object of the Customers class.
 */
    public void insert(Customers objCustomers) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(objCustomers);
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
}