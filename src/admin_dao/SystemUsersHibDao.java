package admin_dao;

import beans.SystemUsers;
import common.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SystemUsersHibDao {
/**
 * insert() method is invoked by the insertupdate() method of the Action class when a user keys in the desired data and clicks Save.
 * It performs an insert operation [using save()].
 * The captured form data is passed to the save() method which is made available by the insertupdate() method as a method parameter.
 * @param objSystemUsers An object of the SystemUsers class.
 */
    public void insert(SystemUsers objSystemUsers) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(objSystemUsers);
            tx.commit();
        }
        catch (RuntimeException e) {
            if(objSystemUsers != null)
                tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }

/**
 * update() method is invoked by the insertupdate() method of the Action class when a user edits the desired data and clicks Save.
 * It performs an update operation [using update()].
 * The captured modified form data is passed to the update() method which is made available by the insertupdate() method as a method parameter.
 * @param objSystemUsers An object of the SystemUsers class.
 */
    public void update(SystemUsers objSystemUsers) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(objSystemUsers);
            tx.commit();
        }
        catch (RuntimeException e) {
            if(objSystemUsers != null)
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
 * The data of the chosen record is loaded into an object using UserNo as the record identifier.
 * This loaded object is then passed to the delete() method for actual deletion.
 * @param UserNo The User No.
 */
    public void delete(int UserNo) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        Object SystemUsers = null;

        try {
            tx = session.beginTransaction();
            SystemUsers = session.load(SystemUsers.class, UserNo);
            session.delete(SystemUsers);
            tx.commit();
        }
        catch (RuntimeException e) {
            if(SystemUsers != null)
                tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }

/**
 * edit() method is invoked by the edit() method of the Action class when a user chooses a record from the data grid in the JSP page for editing it.
 * This method receives UserNo which is used as the WHERE clause criteria.
 * It queries the database to retrieve the chosen record's data to return to the edit() method for populating the data entry form.
 * To prevent any kinds of errors, uniqueResult() is applied which ensures that only unique record is retrived.
 * @param UserNo The User No.
 */
    public SystemUsers edit(int UserNo) {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM SystemUsers WHERE UserNo = :UserNo");
            query.setInteger("UserNo", UserNo);
            return (SystemUsers) query.uniqueResult();
        }
        finally {
            session.close();
        }
    }
}