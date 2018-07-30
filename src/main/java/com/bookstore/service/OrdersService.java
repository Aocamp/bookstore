package com.bookstore.service;
import java.util.Date;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bookstore.database.OrdersDAO;
import com.bookstore.model.Orders;
import com.bookstore.model.OrdersModify;

@Path("orders")
public class OrdersService {

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Orders> getAllOrders() {
        return OrdersDAO.getAllOrders();
    }

    @GET
    @Path("/{orderId}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Orders getOrders(@PathParam("orderId") String orderId) {
        return OrdersDAO.getOrders(orderId);
    }

    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Orders addOrders(Orders orders ) throws Exception {
        return OrdersDAO.addOrders(orders);
    }

    @PUT
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Orders updateOrders(Orders orders) {
        return OrdersDAO.updateOrders(orders);
    }

    @DELETE
    @Path("/{orderId}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void deleteOrders(@PathParam("orderId") String orderNo) {
        try {
            OrdersDAO.deleteOrders(orderNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

