package frontend;

import beans.CartItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

public class cartAction extends ActionSupport implements SessionAware{
/**
 * A list object to hold the cart items retrieved from the session.
 */
    private List cartItems;
/**
 * Variables to hold the book identity number, the cost of the book and the total cost of books purchased.
 */
    private int BookNo, Cost, totalCost;
/**
 * A Variable to hold the book name.
 */
    private String BookName;
/**
 * A map object to hold current session.
 */
    private Map session;

/**
 * A getter method for the book identity number.
 * @return The book identity number.
 */
    public int getBookNo() {
        return BookNo;
    }
/**
 * A setter method for the book identity number.
 * @param BookNo The book identity number.
 */
    public void setBookNo(int BookNo) {
        this.BookNo = BookNo;
    }

/**
 * A getter method for the cost of book.
 * @return The cost of the book.
 */
    public int getCost() {
        return Cost;
    }
/**
 * A setter method for the cost of book.
 * @param Cost The cost of book.
 */
    public void setCost(int Cost) {
        this.Cost = Cost;
    }

/**
 * A getter method for the total cost of the books purchased.
 * @return The total cost of the books purchased.
 */
    public int getTotalCost() {
        return totalCost;
    }
/**
 * A setter method for the total cost of the books purchased.
 * @param totalCost The total cost of the books purchased.
 */
    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

/**
 * A getter method for the book name.
 * @return The book name.
 */
    public String getBookName() {
        return BookName;
    }
/**
 * A setter method for the book name.
 * @param BookName The book name.
 */
    public void setBookName(String BookName) {
        this.BookName = BookName;
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
 * A getter method for the List of the cart items created earlier.
 * @return A list of cart items.
 */
    public List getCartItems() {
        return cartItems;
    }
/**
 * A setter method for the List of the cart items created earlier.
 * @param cartItems A list of cart items.
 */
    public void setCartItems(List cartItems) {
        this.cartItems = cartItems;
    }

/**
 * show() in invoked when the user clicks Cart from the home page to view the cart and the items it holds.
 * This method retrieves the session contents that are related to the cart and populates the same in the List object.
 * This List object is then made available to the showCart.jsp page that displays the cart items to the user.
 * @throws java.lang.Exception
 */
    public String show() throws Exception{
        cartItems = new ArrayList();

        for (Iterator it = session.entrySet().iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();

            if(!(key.toString().equals("username") || key.toString().equals("lastlogin") || key.toString().equals("lastip"))) {
                CartItem cart = new CartItem();
                cart.setBookName(key.toString());
                cart.setCost(value.toString());
                totalCost += Integer.parseInt(value.toString());
                cartItems.add(cart);
            }
        }
        return SUCCESS;
    }

/**
 * addBook() method is invoked when a user clicks Add To Cart link for a desired book.
 * This method appends the current date time stamp to the book and adds the book details i.e. the book name and its cost to the session.
 * @throws java.lang.Exception
 */
    public String addBook() throws Exception{
        String datetime = (new java.util.Date()).toString();
        String book = datetime + " - " + BookName;
        int cost = Cost;
        session = ActionContext.getContext().getSession();
        session.put(book, cost);
        return SUCCESS;
    }

/**
 * removeBook() method is invoked when the user choose to delete a book from the cart.
 * This method removes the selected book from the session.
 * @throws java.lang.Exception
 */
    public String removeBook() throws Exception{
        session = ActionContext.getContext().getSession();
        session.remove(BookName);
        return SUCCESS;
    }
}