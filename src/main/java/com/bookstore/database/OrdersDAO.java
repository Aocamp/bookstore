package com.bookstore.database;

import com.bookstore.model.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;


public class OrdersDAO {
    private static final Map<String, Orders> clMap = new HashMap<>();

   /* static {
        try {
            initOrders();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initOrders() {
        Orders orders = new Orders();
        try {
            ConnectionManager connection = new ConnectionManager();
            Connection conn = connection.getNewConnection();
            String query = "SELECT orders.order_id, clients.client_name, books.book_name, orders.order_date FROM orders INNER JOIN clients ON orders.client_id = clients.client_id INNER JOIN books ON orders.book_id=books.book_id ";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                orders.setOrderId(rs.getString("order_id"));
                orders.setClientId(rs.getString("client_name"));
                orders.setBookId(rs.getString("book_name"));
                orders.setOrderDate(rs.getString("order_date"));
                clMap.put(orders.getOrderId(), orders);
            }
            connection.closeConnection(conn);
        } catch(Exception e){

            }

    }
    */

    public static Orders getOrders(String orderId) {
        return clMap.get(orderId);
    }

    public static Orders addOrders(Orders orders) throws Exception {
            ConnectionManager connection = new ConnectionManager();
            Connection conn = connection.getNewConnection();
            PreparedStatement st = conn.prepareStatement("INSERT INTO orders (client_id, book_id, order_date) VALUES ( ?, ?, ?)");
            int col = 1;
            st.setString(col, orders.getClientId());
            st.setString(++col, orders.getBookId());
            st.setString(++col, orders.getOrderDate());
            st.executeUpdate();
            connection.closeConnection(conn);
            return orders;
    }
    public static Orders updateOrders(Orders orders) {
        clMap.put(orders.getOrderId(), orders);
        return orders;
    }

    public static void deleteOrders(String orderId) {
        try {
            ConnectionManager connection = new ConnectionManager();
            Connection conn = connection.getNewConnection();
            PreparedStatement st = conn.prepareStatement("DELETE FROM orders WHERE order_id like ?");
            int col = 1;
            st.setString(col, orderId);
            st.executeUpdate();
            connection.closeConnection(conn);
        } catch (Exception e) {

        }

    }

    public static void deleteAllOrders() {
        try {
            ConnectionManager connection = new ConnectionManager();
            Connection conn = connection.getNewConnection();
            PreparedStatement st = conn.prepareStatement("DELETE * FROM orders ");
            st.executeUpdate();
            connection.closeConnection(conn);
        } catch (Exception e) {

        }

    }

    public static List<Orders> getAllOrders() {
        Orders orders = new Orders();
        try {
            ConnectionManager connection = new ConnectionManager();
            Connection conn = connection.getNewConnection();
            String query = "SELECT orders.order_id, clients.client_name, books.book_name, orders.order_date FROM orders INNER JOIN clients ON orders.client_id = clients.client_id INNER JOIN books ON orders.book_id=books.book_id ";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                orders.setOrderId(rs.getString("order_id"));
                orders.setClientId(rs.getString("client_name"));
                orders.setBookId(rs.getString("book_name"));
                orders.setOrderDate(rs.getString("order_date"));
                clMap.put(orders.getOrderId(), orders);
            }
            connection.closeConnection(conn);
        } catch(Exception e){

        }

        Collection<Orders> ord = clMap.values();
        List<Orders> list = new ArrayList<>();
        list.addAll(ord);
        return list;
    }


}