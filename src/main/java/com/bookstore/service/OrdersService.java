package com.bookstore.service;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.bookstore.database.OrdersDAO;
import com.bookstore.model.Orders;

@Path("orders")
public class OrdersService {

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Orders> getAllOrders() throws Exception {
        return OrdersDAO.getAllOrders();
    }

    @GET
    @Path("/{orderId}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Orders getOrders(@PathParam("orderId") String orderId) throws Exception {
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
    public void deleteOrders(@PathParam("orderId") String orderId) {
        OrdersDAO.deleteOrders(orderId);
    }

    @DELETE
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void deleteOrders() {
        OrdersDAO.deleteAllOrders();
    }

}

