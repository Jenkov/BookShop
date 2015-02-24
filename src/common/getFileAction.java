package common;

import java.sql.*;
import java.io.InputStream;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import com.opensymphony.xwork2.ActionSupport;

public class getFileAction extends ActionSupport{
/**
 * Variables to hold the table name, column name, the column name of the where clause and the column value of the where clause.
 */
    private String columnName, tableName, whereClause, whereClauseValue;
/**
 * Variable to hold the input stream.
 */
    private InputStream iStream = null;

/**
 * The constructor of the getFileAction class.
 */
    public getFileAction() {
    }

/**
 * A getter method for the column name.
 * @return The column name.
 */
    public String getColumnName() {
        return columnName;
    }
/**
 * A setter method for the column name.
 * @param columnName The column name.
 */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

/**
 * A getter method for the column name used in the WHERE clause.
 * @return The column name used in the WHERE clause.
 */
    public String getWhereClause() {
        return whereClause;
    }
/**
 * A setter method for the column name used in the WHERE clause.
 * @param whereClause The column name used in the WHERE clause.
 */
    public void setWhereClause(String whereClause) {
        this.whereClause = whereClause;
    }

/**
 * A getter method for the value of the column name used in the WHERE clause.
 * @return The value of the column name used in the WHERE clause.
 */
    public String getWhereClauseValue() {
        return whereClauseValue;
    }
/**
 * A setter method for the value of the column name used in the WHERE clause.
 * @param whereClauseValue The value of the column name used in the WHERE clause.
 */
    public void setWhereClauseValue(String whereClauseValue) {
        this.whereClauseValue = whereClauseValue;
    }

/**
 * A getter method for the table name.
 * @return The table name.
 */    public String getTableName() {
        return tableName;
    }
/**
 * A setter method for the table name.
 * @param tableName The table name.
 */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

/**
 * A getter method for the input stream.
 * @return The input stream.
 */
    public InputStream getIStream() {
        return iStream;
    }
/**
 * A setter method for the input stream.
 * @param iStream The input stream.
 */
    public void setIStream(InputStream iStream) {
        this.iStream = iStream;
    }

/**
 * execute() method is invoked evertime the BLOB content [photograph or a PDF file] needs to be downloaded and viewed.
 * This method uses a native SQL query to retrieve the BLOB contents.
 * This query is formed on the basis of columnName, tableName, whereClause, whereClauseValue.
 * Based on the values held in these action class variables the SQL query retrives only the BLOB content of a particular record.
 * The content retrieved are assigned to an InputStream object which is streamed and made available to the calling JSP page by the Struts 2 Framework.
 * If the content being asked for is not available in the database table, then the default photograph is retrived from the DefaultValues table and returned instead.
 * @throws java.lang.Exception
 */
    @Override
    public String execute() throws Exception {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            String strQuery = "SELECT " + columnName + " FROM "+ tableName + " WHERE " + whereClause + " = " + whereClauseValue;
            Query query = session.createSQLQuery(strQuery).addScalar(columnName, Hibernate.BLOB);
            Blob blobFile = (Blob) query.uniqueResult();
            iStream = blobFile.getBinaryStream();
        }
        catch(Exception e) {
            session.beginTransaction();
            String strQuery = "SELECT Image FROM DefaultValues";
            Query query = session.createSQLQuery(strQuery).addScalar("Image", Hibernate.BLOB);
            Blob blobFile = (Blob) query.uniqueResult();
            iStream = blobFile.getBinaryStream();
        }
        finally {
            session.close();
        }
        return SUCCESS;
    }
}