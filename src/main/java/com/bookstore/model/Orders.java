package com.bookstore.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ordersList")
@XmlAccessorType(XmlAccessType.FIELD)

public class Orders {
    private String orderId;
    private String clientName;
    private String bookName;
    private String orderDate;

    public Orders(){

    }

    public Orders(String orderId, String clientName, String bookName, String orderDate){
        this.orderId=orderId;
        this.clientName=clientName;
        this.bookName=bookName;
        this.orderDate=orderDate;
    }

    public String getOrderId() { return orderId; }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

}

