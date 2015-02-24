package frontend_dao;

import beans.Transactions;
import common.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class performTransactionHibDao {
/**
 * insert() method is invoked by the addTransactions() method of the Action class when a user makes any purchases .
 * It performs an insert operation [using save()].
 * The captured form data is passed to the save() method which is made available by the addTransactions() method as a method parameter.
 * @param objTransactions An object of the Transactions class.
 */
    public void insert(Transactions objTransactions){
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(objTransactions);
            tx.commit();
        }
        catch (RuntimeException e) {
            if(objTransactions != null)
            tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }

/**
 * getNextTransactionNo() method is invoked by the Action class's addTransactions() method everytime a record is added in the Transactions table.
 * It retrieves [using createSQLQuery()] and returns the same to the addTransactions() method.
 */
    public int getNextTransactionNo(){
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            Object TransactionNo = session.createSQLQuery("SELECT MAX(TransactionNo)+1 AS TransactionNo FROM Transactions").addScalar("TransactionNo").uniqueResult();
            return Integer.parseInt(TransactionNo.toString());
        }
        catch(RuntimeException e){
            return 1;
        }
        finally {
            session.close();
        }
    }
}