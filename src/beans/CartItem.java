package beans;

public class CartItem {
    private String BookName, Cost;

    public CartItem() {
    }

    public CartItem(String BookName, String Cost) {
        this.BookName = BookName;
        this.Cost = Cost;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String Cost) {
        this.Cost = Cost;
    }
}