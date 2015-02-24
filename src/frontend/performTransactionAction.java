package frontend;

import beans.CartItem;
import beans.Transactions;
import java.util.Iterator;
import java.util.Map;
import frontend_dao.performTransactionHibDao;
import java.util.Date;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.interceptor.SessionAware;

public class performTransactionAction extends ActionSupport implements SessionAware{
/**
 * An object of the performTransactionHibDao class to perform transactions based on the purchases made.
 * Methods of this object will be invoked to service these data operation requests.
 * These methods will be invoked by the action class methods.
 */
    private performTransactionHibDao transactionsHibDao = new performTransactionHibDao();
/**
 * A list object to hold the cart items retrieved from the session.
 */
    private List cartItems;
/**
 * A map object to hold current session.
 */
    private Map session;

/**
 * A getter method for the list of the cart items created earlier.
 * @return The cart item list.
 */
    public List getCartItems() {
        return cartItems;
    }
/**
 * A setter method for the list of the cart items created earlier.
 * @param cartItems The cart item list.
 */
    public void setCartItems(List cartItems) {
        this.cartItems = cartItems;
    }

/**
 * A getter method for the current session.
 * @return The current session.
 */
    public Map getSession() {
        return session;
    }
/**
 * A setter method for the current session.
 * @param session The current session.
 */
    public void setSession(Map session) {
        this.session = session;
    }

/**
 * addTransactions() is invoked when the user click Google Checkout.
 * This method retrieves the session contents [related to the cart i.e. the bookname and the book cost] and inserts them as transactions
 * in the Transactions table with the help of the DAO object's insert() method.
 * Finally, the extracted session contents [related to the cart items] are added to a list object which will be made available to the
 * performTransactions.jsp page for onward submission to Google Checkout payment gateway.
 * @throws java.lang.Exception
 */
    public String addTransactions() throws Exception{
        cartItems = new ArrayList();

        for (Iterator it = session.entrySet().iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            int transactionNo = transactionsHibDao.getNextTransactionNo();

            if(!(key.toString().equals("username") || key.toString().equals("lastlogin") || key.toString().equals("lastip"))) {
                Transactions transaction = new Transactions();
                transaction.setUsername(session.get("username").toString());
                transaction.setBookName(key.toString());
                transaction.setCost(Integer.parseInt(value.toString()));
                transaction.setQty(1);
                transaction.setTransactionDate(new Date());
                transaction.setTransactionNo(transactionNo);
                transactionsHibDao.insert(transaction);

                CartItem cart = new CartItem();
                cart.setBookName(key.toString());
                cart.setCost(value.toString());
                cartItems.add(cart);
            }
        }
        return SUCCESS;
    }
}