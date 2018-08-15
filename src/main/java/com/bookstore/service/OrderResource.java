package com.bookstore.service;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.bookstore.database.OrderService;
import com.bookstore.model.Orders;

@Path("orders")
public class OrderResource {

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Orders> getAllOrders()  {
        return OrderService.getAllOrders();
    }

    @GET
    @Path("/{orderId}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Orders getOrders(@PathParam("orderId") String orderId) {
            return OrderService.getOrders(orderId);
    }

    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Orders addOrders(Orders orders )  {
        return OrderService.addOrders(orders);
    }

    @PUT
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Orders updateOrders(Orders orders) {
        return OrderService.updateOrders(orders);
    }

    @DELETE
    @Path("/{orderId}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void deleteOrders(@PathParam("orderId") String orderId) {
        OrderService.deleteOrders(orderId);
    }


}

