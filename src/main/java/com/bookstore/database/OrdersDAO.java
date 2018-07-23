package com.bookstore.database;

import com.bookstore.model.Orders;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrdersDAO {
    private static final Map<String, Orders> clMap = new HashMap<>();

    static {
        try {
            initOrders();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initOrders() throws Exception {
        ConnectionManager connection = new ConnectionManager();
        Connection conn = connection.getNewConnection();
        String query = "select orders.order_id, clients.client_name, books.book_name, orders.order_date from orders inner join clients on orders.client_id = clients.client_id inner join books on orders.book_id=books.book_id ";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next())
        {
            Orders orders = new Orders();
            orders.setOrderNo(rs.getString("order_id"));
            orders.setClientName(rs.getString("client_name"));
            orders.setBookName(rs.getString("book_name"));
            orders.setOrderDate(rs.getString("order_date"));
            clMap.put(orders.getOrderNo(), orders);
        }
        connection.closeConnection(conn);
    }

    public static Orders getOrders(String orderNo) {
        return clMap.get(orderNo);
    }

    public static Orders addOrders(Orders orders) {
        clMap.put(orders.getOrderNo(), orders);
        return orders;
    }

    public static Orders updateOrders(Orders orders) {
        clMap.put(orders.getOrderNo(), orders);
        return orders;
    }

    public static void deleteOrders(String orderNo) {
        clMap.remove(orderNo);
    }

    public static List<Orders> getAllOrders() {
        Collection<Orders> orders = clMap.values();
        List<Orders> list = new ArrayList<>();
        list.addAll(orders);
        return list;
    }
}