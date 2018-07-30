package com.bookstore.database;

import com.bookstore.model.Orders;
import com.bookstore.model.OrdersModify;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

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
            orders.setOrderId(rs.getString("order_id"));
            orders.setClientName(rs.getString("client_name"));
            orders.setBookName(rs.getString("book_name"));
            orders.setOrderDate(rs.getString("order_date"));
            clMap.put(orders.getOrderId(), orders);
        }
        connection.closeConnection(conn);
    }

    public static Orders getOrders(String orderId) {

        return clMap.get(orderId);
    }

    public static Orders addOrders(Orders orders) throws Exception {
        Orders ord = new Orders();
        ConnectionManager connection = new ConnectionManager();
        Connection conn = connection.getNewConnection();
        PreparedStatement st = conn.prepareStatement("INSERT INTO orders (order_id, client_id, book_id, order_date) VALUES (? , ?, ?, ?)");
        st.setString(1, ord.getOrderId());
        st.setString(2, ord.getClientName());
        st.setString(3, ord.getBookName());
        st.setString(4, ord.getOrderDate());
        clMap.put(orders.getOrderId(), orders);

        st.executeUpdate();

        return orders;
    }

    public static Orders updateOrders(Orders orders) {
        clMap.put(orders.getOrderId(), orders);
        return orders;
    }

    public static void deleteOrders(String orderNo) throws Exception {
        ConnectionManager connection = new ConnectionManager();
        Connection conn = connection.getNewConnection();
        PreparedStatement pstmt = conn.prepareStatement("DELETE FROM "
                + "orders "
                + "WHERE orderNo LIKE ?");
        //pstmt.setString(1, orderNo);
        //pstmt.executeUpdate();
        clMap.remove(orderNo);
    }

    public static List<Orders> getAllOrders() {
        Collection<Orders> orders = clMap.values();
        List<Orders> list = new ArrayList<>();
        list.addAll(orders);
        return list;
    }
}