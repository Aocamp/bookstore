package com.bookstore.model;

public class OrdersModify {
    private int orderId;
    private int clientId;
    private int bookId;
    private int orderDate;

    public OrdersModify(){

    }

    public OrdersModify(int orderId, int clientId, int bookId, int orderDate){
        this.orderId=orderId;
        this.clientId=clientId;
        this.bookId=bookId;
        this.orderDate=orderDate;
    }

    public int getOrderId() { return orderId; }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(int orderDate) {
        this.orderDate = orderDate;
    }
}
