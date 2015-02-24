package frontend_dao;

import beans.Books;
import common.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class showBookDetailsHibDao {
/**
 * getAllBooks() method is invoked by the viewBooks() method of the Action class when a user clicks on the Book name in the JSP page for viewing it.
 * This method receives BookNo which is used as the WHERE clause criteria.
 * It queries the database to retrieve the chosen record's data to return to the viewBooks() method for displaying the data in the JSP page.
 * To prevent any kinds of errors, uniqueResult() is applied which ensures that only unique record is retrived.
 */
    public Books getAllBooks(int BookNo) {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM Books WHERE BookNo = :BookNo");
            query.setInteger("BookNo", BookNo);
            Books objBook = (Books) query.uniqueResult();
            updateHits(objBook);
            return objBook;
        }
        finally {
            session.close();
        }
    }

/**
 * updateHits() method is invoked by the getAllBooks() method when a user views a book's details.
 * It performs an update operation [using update()].
 * The book data is passed to the update() method which is made available by the getAllBooks() method as a method parameter.
 * @param objBooks An object of the Books class.
 */
    public void updateHits(Books objBooks) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            objBooks.setHits(objBooks.getHits()+1);
            session.update(objBooks);
            tx.commit();
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
}