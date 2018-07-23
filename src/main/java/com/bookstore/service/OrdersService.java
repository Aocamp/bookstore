package com.bookstore.service;
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

@Path("/orders")
public class OrdersService {

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Orders> getOrders_JSON() {
        List<Orders> list = OrdersDAO.getAllOrders();
        return list;
    }

    @GET
    @Path("/{orderNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Orders getOrders(@PathParam("orderNo") String orderNo) {
        return OrdersDAO.getOrders(orderNo);
    }

    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Orders addOrders (Orders orders) {
        return OrdersDAO.addOrders(orders);
    }

    @PUT
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Orders updateOrders(Orders orders) {
        return OrdersDAO.updateOrders(orders);
    }

    @DELETE
    @Path("/{orderNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void deleteOrders(@PathParam("orderNo") String orderNo) {
        OrdersDAO.deleteOrders(orderNo);
    }

}

