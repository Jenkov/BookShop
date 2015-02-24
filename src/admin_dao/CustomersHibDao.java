package admin_dao;

import beans.Customers;
import common.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomersHibDao {
/**
 * update() method is invoked by the update() method of the Action class when a user edits the desired data and clicks Save.
 * It performs an update operation [using update()].
 * The captured modified form data is passed to the update() method which is made available by the insertupdate() method as a method parameter.
 * @param objCustomers An object of the Customers class.
 */
    public void update(Customers objCustomers) {
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
 * delete() method is invoked by the delete() method of the Action class when a user clicks X adjacent to the desired record from the data grid in the JSP page.
 * It performs a delete operation [using delete()].
 * The data of the chosen record is loaded into an object using CustomerNo as the record identifier.
 * This loaded object is then passed to the delete() method for actual deletion.
 * @param CustomerNo The Customer No.
 */
    public void delete(int CustomerNo) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        Object Customers = null;

        try {
            tx = session.beginTransaction();
            Customers = session.load(Customers.class, CustomerNo);
            session.delete(Customers);
            tx.commit();
        }
        catch (RuntimeException e) {
            if(Customers != null)
                tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }

/**
 * edit() method is invoked by the edit() method of the Action class when a user chooses a record from the data grid in the JSP page for editing it.
 * This method receives CustomerNo which is used as the WHERE clause criteria.
 * It queries the database to retrieve the chosen record's data to return to the edit() method for populating the data entry form.
 * To prevent any kinds of errors, uniqueResult() is applied which ensures that only unique record is retrived.
 * @param CustomerNo The Customer No.
 */
    public Customers edit(int CustomerNo) {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM Customers WHERE CustomerNo = :CustomerNo");
            query.setInteger("CustomerNo", CustomerNo);
            return (Customers) query.uniqueResult();
        }
        finally {
            session.close();
        }
    }
}