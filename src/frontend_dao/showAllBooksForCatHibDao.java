package frontend_dao;

import beans.Categories;
import common.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class showAllBooksForCatHibDao {
/**
 * getAllCategories() method is invoked by the viewCategoryBooks() method of the Action class when a user clicks on the Category name in the JSP page for viewing it.
 * This method receives CategoryNo which is used as the WHERE clause criteria.
 * It queries the database to retrieve the chosen record's data to return to the viewCategoryBooks() method for displaying the data in the JSP page.
 * To prevent any kinds of errors, uniqueResult() is applied which ensures that only unique record is retrived.
 */
    public Categories getAllCategories(int CategoryNo) {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM Categories WHERE CategoryNo = :CategoryNo");
            query.setInteger("CategoryNo", CategoryNo);
            return (Categories) query.uniqueResult();
        }
        finally {
            session.close();
        }
    }

/**
 * getAllBooksOfThisCategory() method is invoked by the Action class's viewCategoryBooks() method everytime the user clicks the Category name in the Homepage to view the book details of that particular category.
 * It retrieves [using createQuery()] and returns the same to the viewCategoryBooks() method.
 * This List will be used in the JSP page's <s:iterator> tag to form the data grid.
 * This data grid displays existing records from the Books table.
 */
    public List getAllBooksOfThisCategory(int CategoryNo) {
        Session session = HibernateUtil.getSession();

        try {
            Query query = session.createQuery("FROM Books WHERE CategoryNo = :CategoryNo");
            query.setInteger("CategoryNo", CategoryNo);
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