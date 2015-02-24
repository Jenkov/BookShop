package common;

import admin_dao.populateDdlbsHibDao;
import beans.Authors;
import beans.Categories;
import beans.CityState;
import beans.Countries;
import beans.Publishers;
import java.util.List;

public class populateDdlbs {
/**
 * A List type object of the Countries bean class.
 * This List object will be populated by the constructor with the records available in the Countries table.
 * This List object will be used to display existing records in the JSP page's drop down list box.
 */
    private List<Countries> ddlbCountries;
/**
 * A List type object of the CityState bean class.
 * This List object will be populated by the constructor with the records available in the CityState table.
 * This List object will be used to display existing records in the JSP page's drop down list box.
 */
    private List<CityState> ddlbCitiesStates;
/**
 * A List type object of the Authors bean class.
 * This List object will be populated by the constructor with the records available in the Authors table.
 * This List object will be used to display existing records in the JSP page's drop down list box.
 */
    private List<Authors> ddlbAuthors;
/**
 * A List type object of the Publishers bean class.
 * This List object will be populated by the constructor with the records available in the Publishers table.
 * This List object will be used to display existing records in the JSP page's drop down list box.
 */
    private List<Publishers> ddlbPublishers;
/**
 * A List type object of the Categories bean class.
 * This List object will be populated by the constructor with the records available in the Categories table.
 * This List object will be used to display existing records in the JSP page's drop down list box.
 */
    private List<Categories> ddlbCategories;
/**
 * An object of the populateDdlbsHibDao class to service DDLBs population.
 * Methods of this object will be invoked to service these requests.
 * These methods will be invoked by the action class methods.
 */
    private populateDdlbsHibDao populateDdlbsService = new populateDdlbsHibDao();

/**
 * The class constructor that populates all the list objects.
 * These list objects will be made available to the action class when an object of this class is created.
 */
    public populateDdlbs() {
        ddlbCountries = populateDdlbsService.getAllCountries();
        ddlbCitiesStates = populateDdlbsService.getAllCitiesStates();
        ddlbAuthors = populateDdlbsService.getAllAuthors();
        ddlbPublishers = populateDdlbsService.getAllPublishers();
        ddlbCategories = populateDdlbsService.getAllCategories();
    }

/**
 * A getter method for the List object of the Countries bean class created earlier.
 * @return A list object of Countries.
 */
    public List<Countries> getDdlbCountries() {
        return ddlbCountries;
    }
/**
 * A setter method for the List object of the Countries bean class created earlier.
 * @param ddlbCountries A list object of Countries.
 */
    public void setDdlbCountries(List<Countries> ddlbCountries) {
        this.ddlbCountries = ddlbCountries;
    }

/**
 * A getter method for the List object of the CityState bean class created earlier.
 * @return A list object of CityState.
 */
    public List<CityState> getDdlbCitiesStates() {
        return ddlbCitiesStates;
    }
/**
 * A setter method for the List object of the CityState bean class created earlier.
 * @param ddlbCitiesStates A list object of CityState.
 */
    public void setDdlbCitiesStates(List<CityState> ddlbCitiesStates) {
        this.ddlbCitiesStates = ddlbCitiesStates;
    }

/**
 * A getter method for the List object of the Authors bean class created earlier.
 * @return A list object of Authors.
 */
    public List<Authors> getDdlbAuthors() {
        return ddlbAuthors;
    }
/**
 * A setter method for the List object of the Authors bean class created earlier.
 * @param ddlbAuthors A list object of Authors.
 */
    public void setDdlbAuthors(List<Authors> ddlbAuthors) {
        this.ddlbAuthors = ddlbAuthors;
    }

/**
 * A getter method for the List object of the Categories bean class created earlier.
 * @return A list object of Categories.
 */
    public List<Categories> getDdlbCategories() {
        return ddlbCategories;
    }
/**
 * A setter method for the List object of the Categories bean class created earlier.
 * @param ddlbCategories A list object of Categories.
 */
    public void setDdlbCategories(List<Categories> ddlbCategories) {
        this.ddlbCategories = ddlbCategories;
    }

/**
 * A getter method for the List object of the Publishers bean class created earlier.
 * @return A list object of Publishers.
 */
    public List<Publishers> getDdlbPublishers() {
        return ddlbPublishers;
    }
/**
 * A setter method for the List object of the Publishers bean class created earlier.
 * @param ddlbPublishers A list object of Publishers.
 */
    public void setDdlbPublishers(List<Publishers> ddlbPublishers) {
        this.ddlbPublishers = ddlbPublishers;
    }
}