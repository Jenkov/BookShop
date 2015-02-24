package admin_dao;

import common.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class LoginHibDao {
/**
 * validateLogin() method is invoked by the login() method of the Action class to authenticate System Users.
 * This method receives Username and Password which is used as the WHERE clause criteria.
 * It queries the database to retrieve the chosen record's data to return to the login() method.
 * @param Username The Username.
 * @param Password The Password.
*/
    public Object validateLogin(String Username, String Password) {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM SystemUsers WHERE Username = :Username AND Password = :Password");
            query.setString("Username", Username);
            query.setString("Password", Password);
            return query.uniqueResult();
        }
        finally {
            session.close();
        }
    }
}