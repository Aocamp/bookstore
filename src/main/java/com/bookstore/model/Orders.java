package com.bookstore.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ordersList")
@XmlAccessorType(XmlAccessType.FIELD)

public class Orders {
    private String orderId;
    private String clientId;
    private String bookId;
    private String orderDate;

    public Orders(){

    }

    public Orders(String orderId, String clientId, String bookId, String orderDate){
        this.orderId=orderId;
        this.clientId=clientId;
        this.bookId=bookId;
        this.orderDate=orderDate;
    }

    public String getOrderId() { return orderId; }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

}

