package admin_dao;

import beans.Books;
import beans.Customers;
import com.opensymphony.xwork2.ActionContext;
import common.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import common.sendMail;
import java.util.Locale;
import java.util.ResourceBundle;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BooksHibDao {
/**
 * insert() method is invoked by the insertupdate() method of the Action class when a user keys in the desired data and clicks Save.
 * It performs an insert operation [using save()].
 * The captured form data is passed to the save() method which is made available by the insertupdate() method as a method parameter.
 * @param objBooks An object of the Books class.
 */
    public void insert(Books objBooks) throws Exception {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(objBooks);
            tx.commit();
            notifyNewRealeasesToCustomers(objBooks);
        }
        catch (RuntimeException e) {
            if(objBooks != null)
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
 * @param objBooks An object of the Books class.
 */
    public void update(Books objBooks) throws Exception {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(objBooks);
            tx.commit();
            notifyUpdatesToCustomers(objBooks);
        }
        catch (RuntimeException e) {
            if(objBooks != null)
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
 * The data of the chosen record is loaded into an object using BookNo as the record identifier.
 * This loaded object is then passed to the delete() method for actual deletion.
 * @param BookNo The Book No.
 */
    public void delete(int BookNo) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        Object Books = null;

        try {
            tx = session.beginTransaction();
            Books = session.load(Books.class, BookNo);
            session.delete(Books);
            tx.commit();
        }
        catch (RuntimeException e) {
            if(Books != null)
                tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }

/**
 * edit() method is invoked by the edit() method of the Action class when a user chooses a record from the data grid in the JSP page for editing it.
 * This method receives BookNo which is used as the WHERE clause criteria.
 * It queries the database to retrieve the chosen record's data to return to the edit() method for populating the data entry form.
 * To prevent any kinds of errors, uniqueResult() is applied which ensures that only unique record is retrived.
 * @param BookNo The Book No.
 */
    public Books edit(int BookNo) {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM Books WHERE BookNo = :BookNo");
            query.setInteger("BookNo", BookNo);
            return (Books) query.uniqueResult();
        }
        finally {
            session.close();
        }
    }
/**
 * notifyNewRealeasesToCustomers() method is invoked by the insert() method when a user adds a new book and clicks Save.
 * It dispatches emails to notify the appropriate customers about such changes.
 * @param objBooks An object of the Books class.
 */
    public void notifyNewRealeasesToCustomers(Books objBooks) throws Exception {
        Session session = HibernateUtil.getSession();

        try {
            Locale locale = ActionContext.getContext().getLocale();
            ResourceBundle bundle = ResourceBundle.getBundle("bookshop", locale);
            if(!bundle.getString("emailFrom").equals("") && !bundle.getString("emailUser").equals("") && !bundle.getString("emailFromPasswd").equals("")) {
                session.beginTransaction();
                List<Customers> customers = session.createQuery("FROM Customers WHERE NewRelease = 'true'").list();

                for (Iterator i = customers.iterator(); i.hasNext(); ) {
                    Customers objCustomer = (Customers) i.next();
                    String toEmailAddress = objCustomer.getEmailAddress();
                    String emailSubject = "Sharanams Bookshop: " + objBooks.getBookName() + " has been added.";
                    String emailMessage = "<html><head><meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1'/><title>" + objBooks.getBookName() + " has been added.</title></head><body><table width='500' border='0' align='center' cellpadding='15' cellspacing='0' style='font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12pt; color:#5a5a5a;'><tr><td align='left'><p>Dear " + objCustomer.getFirstName() + ",</p></td></tr><tr><td align='left'><p>" + objBooks.getBookName() + " has been updated.</p><br/><br/><p>ISBN: " + objBooks.getISBN() + "<br />Edition: " + objBooks.getEdition() + "<br />Synopsis: " + objBooks.getSynopsis() + "<br />Topics covered: " + objBooks.getTopicsCovered() + "<br /></p><br/><p>Thank you for using  this site.<br /></p><br/><br/><p>Regards,<br />Sharanams Bookshop<br /></p><p><br /><br />THIS IS AN AUTOMATED MESSAGE; PLEASE DO NOT REPLY. </p></td></tr></table></body></html>";
                    sendMail.sendMail(bundle.getString("emailFrom"), bundle.getString("emailUser"), bundle.getString("emailFromPasswd"), toEmailAddress, emailSubject, emailMessage);
                }
            }
        }
        finally {
            session.close();
        }
    }

/**
 * notifyUpdatesToCustomers() method is invoked by the insert() method when a user updates a book and clicks Save.
 * It dispatches emails to notify the appropriate customers about such changes.
 * @param objBooks An object of the Books class.
 */
    public void notifyUpdatesToCustomers(Books objBooks) throws Exception {
        Session session = HibernateUtil.getSession();

        try {
            Locale locale = ActionContext.getContext().getLocale();
            ResourceBundle bundle = ResourceBundle.getBundle("bookshop", locale);
            if(!bundle.getString("emailFrom").equals("") && !bundle.getString("emailUser").equals("") && !bundle.getString("emailFromPasswd").equals("")) {
                session.beginTransaction();
                List<Customers> customers = session.createQuery("FROM Customers WHERE BookUpdates = 'true'").list();

                for (Iterator i = customers.iterator(); i.hasNext(); ) {
                    Customers objCustomer = (Customers) i.next();
                    String toEmailAddress = objCustomer.getEmailAddress();
                    String emailSubject = "Sharanams Bookshop: " + objBooks.getBookName() + " has been updated.";
                    String emailMessage = "<html><head><meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1'/><title>" + objBooks.getBookName() + " has been updated.</title></head><body><table width='500' border='0' align='center' cellpadding='15' cellspacing='0' style='font-family: Verdana, Arial, Helvetica, sans-serif; font-size:12pt; color: #5a5a5a;'><tr><td align='left'><p>Dear " + objCustomer.getFirstName() + ",</p></td></tr><tr><td align='left'><p>" + objBooks.getBookName() + " has been updated.</p><br/><br/><p>ISBN: " + objBooks.getISBN() + "<br />Edition: " + objBooks.getEdition() + "<br />Synopsis: " + objBooks.getSynopsis() + "<br />Topics covered: " + objBooks.getTopicsCovered() + "<br /></p><br/><p>Thank you for using  this site.<br /></p><br/><br/><p>Regards,<br />Sharanams Bookshop<br /></p><p><br /><br />THIS IS AN AUTOMATED MESSAGE; PLEASE DO NOT REPLY. </p></td></tr></table></body></html>";
                    sendMail.sendMail(bundle.getString("emailFrom"), bundle.getString("emailUser"), bundle.getString("emailFromPasswd"), toEmailAddress, emailSubject, emailMessage);
                }
            }
        }
        finally {
            session.close();
        }
    }
}