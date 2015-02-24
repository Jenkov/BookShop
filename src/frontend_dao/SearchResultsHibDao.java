package frontend_dao;

import beans.Authors;
import beans.Books;
import beans.PopularSearches;
import beans.Publishers;
import common.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SearchResultsHibDao {
/**
 * insertPopularSearches() method is invoked whenever the user searches for book, author or publisher details.
 * It performs an insert operation [using save()].
 * The captured form data is passed to the save() method which is made available by the getAllBooksSearchResults(), getAllAuthorsSearchResults() and getAllPublishersSearchResults() meathods as a method parameter.
 */
    public void insertPopularSearches(PopularSearches objPopularSearches) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(objPopularSearches);
            tx.commit();
        }
        catch (RuntimeException e) {
            if(objPopularSearches != null)
                tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }

/**
 * getAllBooksSearchResults() method is invoked by the viewBooksSearchResults() method of the Action class to view the details of Books in the JSP page
 * when the user clicks on the Book button in the Home page or the Search page.
 * This method receives Search criteria which is used as the WHERE clause criteria.
 * It queries the database to retrieve the chosen record's data to return to the viewBooksSearchResults() method for populating the JSP page.
 * It also inserts a record about the word searched for in the PopularSearches table.
 * @param SearchCriteria The search critia.
 */
    public List getAllBooksSearchResults(String SearchCriteria) {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            String strQuery = "SELECT * FROM Books WHERE BookName LIKE '%"+ SearchCriteria + "%' OR ISBN LIKE '%"+ SearchCriteria + "%' OR Edition LIKE '%"+ SearchCriteria + "%' OR Year LIKE '%"+ SearchCriteria + "%' OR Synopsis LIKE '%"+ SearchCriteria + "%' OR AboutAuthors LIKE '%"+ SearchCriteria + "%' OR TopicsCovered LIKE '%"+ SearchCriteria + "%' OR ContentsCDROM LIKE '%"+ SearchCriteria + "%' OR Cost LIKE '%"+ SearchCriteria + "%'";
            Query query = session.createSQLQuery(strQuery).addEntity(Books.class);
            PopularSearches ps = new PopularSearches();
            ps.setCriteria("book");
            ps.setValue(SearchCriteria);
            insertPopularSearches(ps);
            return query.list();
        }
        finally {
            session.close();
        }
    }

/**
 * getAllAuthorsSearchResults() method is invoked by the viewAuthorsSearchResults() method of the Action class to view the details of Authors in the JSP page when the user clicks on the Author button in the Home page or the Search page.
 * This method receives Search criteria which is used as the WHERE clause criteria.
 * It queries the database to retrieve the chosen record's data to return to the viewAuthorsSearchResults() method for populating the JSP page.
 * It also inserts a record about the word searched for in the PopularSearches table.
 * @param SearchCriteria The search critia.
 */
    public List getAllAuthorsSearchResults(String SearchCriteria) {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            String strQuery = "SELECT * FROM Authors WHERE FirstName LIKE '%"+ SearchCriteria + "%' OR LastName LIKE '%"+ SearchCriteria + "%' OR Address1 LIKE '%"+ SearchCriteria + "%' OR Address2 LIKE '%"+ SearchCriteria + "%' OR CityStateNo LIKE '%"+ SearchCriteria + "%' OR CountryNo LIKE '%"+ SearchCriteria + "%' OR Pincode LIKE '%"+ SearchCriteria + "%' OR Degree LIKE '%"+ SearchCriteria + "%' OR Speciality LIKE '%"+ SearchCriteria + "%' OR EmailAddress LIKE '%"+ SearchCriteria + "%'";
            Query query = session.createSQLQuery(strQuery).addEntity(Authors.class);
            PopularSearches ps = new PopularSearches();
            ps.setCriteria("author");
            ps.setValue(SearchCriteria);
            insertPopularSearches(ps);
            return query.list();
        }
        finally {
            session.close();
        }
    }

/**
 * getAllBooksOfThisAuthor() method is invoked by the Action class's viewBooksOfThisAuthor() method everytime the user clicks the Author in the Homepage to view the book details written by that particular author.
 * It retrieves [using createQuery()], populates the List object [books] created earlier and returns the same to the viewBooksOfThisAuthor() method.
 * This List will be used in the JSP page's <s:iterator> tag to form the data grid.
 * This data grid displays existing records from the Books table.
 */
    public List getAllBooksOfThisAuthor(int AuthorNo) {
        Session session = HibernateUtil.getSession();

        try {
            Query query = session.createQuery("FROM Books WHERE Author1No = :AuthorNo OR Author2No = :AuthorNo OR Author3No = :AuthorNo OR Author4No = :AuthorNo");
            query.setInteger("AuthorNo", AuthorNo);
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

/**
 * getAllPublishersSearchResults() method is invoked by the viewPublishersSearchResults() method of the Action class to view the details of Publishers in the JSP page when the user clicks on the Publisher button in the Home page or the Search page.
 * This method receives Search criteria which is used as the WHERE clause criteria.
 * It queries the database to retrieve the chosen record's data to return to the viewPublishersSearchResults() method for populating the JSP page.
 * It also inserts a record about the word searched for in the PopularSearches table.
 * @param SearchCriteria The search critia.
 */
    public List getAllPublishersSearchResults(String SearchCriteria) {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            String strQuery = "SELECT * FROM Publishers WHERE PublisherName LIKE '%"+ SearchCriteria + "%' OR Address1 LIKE '%"+ SearchCriteria + "%' OR Address2 LIKE '%"+ SearchCriteria + "%' OR CityStateNo LIKE '%"+ SearchCriteria + "%' OR CountryNo LIKE '%"+ SearchCriteria + "%' OR Pincode LIKE '%"+ SearchCriteria + "%' OR EmailAddress LIKE '%"+ SearchCriteria + "%'";
            Query query = session.createSQLQuery(strQuery).addEntity(Publishers.class);
            PopularSearches ps = new PopularSearches();
            ps.setCriteria("publisher");
            ps.setValue(SearchCriteria);
            insertPopularSearches(ps);
            return query.list();
        }
        finally {
            session.close();
        }
    }

/**
 * getAllBooksOfThisPublisher() method is invoked by the Action class's viewBooksOfThisPublisher() method everytime the user clicks the Publisher in the Homepage to view the book details published by that particular publisher.
 * It retrieves [using createQuery()], populates the List object [books] created earlier and returns the same to the viewBooksOfThisPublisher() method.
 * This List will be used in the JSP page's <s:iterator> tag to form the data grid.
 * This data grid displays existing records from the Books table.
 */
    public List getAllBooksOfThisPublisher(int PublisherNo) {
        Session session = HibernateUtil.getSession();

        try {
            Query query = session.createQuery("FROM Books WHERE PublisherNo = :PublisherNo");
            query.setInteger("PublisherNo", PublisherNo);
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