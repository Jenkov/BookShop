package admin_dao;

import beans.Authors;
import beans.Categories;
import beans.CityState;
import beans.Countries;
import beans.Publishers;
import common.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class populateDdlbsHibDao {
/**
 * A List type object of the Countries bean class.
 * This List object will be populated by the constructor with the records available in the Countries table.
 * This List object will be used to display existing records in the JSP page's drop down list box.
 */
    private List<Countries> countries;
/**
 * A List type object of the CityState bean class.
 * This List object will be populated by the constructor with the records available in the CityState table.
 * This List object will be used to display existing records in the JSP page's drop down list box.
 */
    private List<CityState> citiesstates;
/**
 * A List type object of the Authors bean class.
 * This List object will be populated by the constructor with the records available in the Authors table.
 * This List object will be used to display existing records in the JSP page's drop down list box.
 */
    private List<Authors> authors;
/**
 * A List type object of the Publishers bean class.
 * This List object will be populated by the constructor with the records available in the Publishers table.
 * This List object will be used to display existing records in the JSP page's drop down list box.
 */
    private List<Publishers> publishers;
/**
 * A List type object of the Categories bean class.
 * This List object will be populated by the constructor with the records available in the Categories table.
 * This List object will be used to display existing records in the JSP page's drop down list box.
 */
    private List<Categories> categories;

/**
 * getAllCountries() method is invoked by the constructor.
 * It retrieves [using createQuery()], populates the List object [Countries] created earlier and returns the same.
 * This List will be used in the JSP page's drop down list box.
 * This drop down list box displays existing records from the Countries table.
 * @return A list object.
 */
    public List getAllCountries() {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            countries = session.createQuery("FROM Countries").list();
            return countries;
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
 * getAllCitiesStates() method is invoked by the constructor.
 * It retrieves [using createQuery()], populates the List object [citiesstates] created earlier and returns the same.
 * This List will be used in the JSP page's drop down list box.
 * This drop down list box displays existing records from the CityState table.
 * @return A list object.
 */
    public List getAllCitiesStates() {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            citiesstates = session.createQuery("FROM CityState").list();
            return citiesstates;
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
 * getAllAuthors() method is invoked by the constructor.
 * It retrieves [using createQuery()], populates the List object [authors] created earlier and returns the same.
 * This List will be used in the JSP page's drop down list box.
 * This drop down list box displays existing records from the Authors table.
 * @return A list object.
 */
    public List getAllAuthors() {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            authors = session.createQuery("FROM Authors").list();
            return authors;
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
 * getAllPublishers() method is invoked by the constructor.
 * It retrieves [using createQuery()], populates the List object [publishers] created earlier and returns the same.
 * This List will be used in the JSP page's drop down list box.
 * This drop down list box displays existing records from the Publishers table.
 * @return A list object.
 */
    public List getAllPublishers() {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            publishers = session.createQuery("FROM Publishers").list();
            return publishers;
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
 * getAllCategories() method is invoked by the constructor.
 * It retrieves [using createQuery()], populates the List object [categories] created earlier and returns the same.
 * This List will be used in the JSP page's drop down list box.
 * This drop down list box displays existing records from the Categories table.
 * @return A list object.
 */
    public List getAllCategories() {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            categories = session.createQuery("FROM Categories").list();
            return categories;
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