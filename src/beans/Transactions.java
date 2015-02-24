package beans;

import java.util.Date;

public class Transactions implements java.io.Serializable{
    private int transactionDetailNo, transactionNo, cost, qty;
    private Date transactionDate;
    private String username, bookName;

    public Transactions() {
    }

    public int getTransactionDetailNo() {
        return transactionDetailNo;
    }

    public void setTransactionDetailNo(int transactionDetailNo) {
        this.transactionDetailNo = transactionDetailNo;
    }

    public int getTransactionNo() {
        return this.transactionNo;
    }
    
    public void setTransactionNo(int transactionNo) {
        this.transactionNo = transactionNo;
    }

    public Date getTransactionDate() {
        return this.transactionDate;
    }
    
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getBookName() {
        return this.bookName;
    }
    
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getCost() {
        return this.cost;
    }
    
    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getQty() {
        return this.qty;
    }
    
    public void setQty(int qty) {
        this.qty = qty;
    }
}