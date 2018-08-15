package com.bookstore.database;

import com.bookstore.model.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;


public class OrderService {
   private static final Map<String, Orders> clMap = new HashMap<>();

    public static List<Orders> getAllOrders() {
        try {
            ConnectionManager connection = new ConnectionManager();
            Connection conn = connection.getNewConnection();
            String query = "SELECT orders.order_id, clients.client_name, books.book_name, orders.order_date FROM orders INNER JOIN clients ON orders.client_id = clients.client_id INNER JOIN books ON orders.book_id=books.book_id ";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Orders orders = new Orders();
                orders.setOrderId(rs.getString("order_id"));
                orders.setClientId(rs.getString("client_name"));
                orders.setBookId(rs.getString("book_name"));
                orders.setOrderDate(rs.getString("order_date"));
                clMap.put(orders.getOrderId(), orders);
            }
            connection.closeConnection(conn);
        } catch(Exception e){
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
       Collection<Orders> ord = clMap.values();
        List<Orders> list = new ArrayList<>(ord);
       return list;
   }


    public static Orders getOrders(String orderId) {
        try {
            ConnectionManager connection = new ConnectionManager();
            Connection conn = connection.getNewConnection();
            String query = "SELECT orders.order_id, clients.client_name, books.book_name, orders.order_date FROM orders INNER JOIN clients ON orders.client_id = clients.client_id INNER JOIN books ON orders.book_id=books.book_id WHERE orders.order_id = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, orderId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Orders orders = new Orders();
                orders.setOrderId(rs.getString("order_id"));
                orders.setClientId(rs.getString("client_name"));
                orders.setBookId(rs.getString("book_name"));
                orders.setOrderDate(rs.getString("order_date"));
                clMap.put(orders.getOrderId(), orders);
            }
            connection.closeConnection(conn);
        } catch(Exception e){
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        System.out.println(clMap.get(orderId));
        return clMap.get(orderId);
    }

    public static Orders addOrders(Orders orders) {
        try {
            ConnectionManager connection = new ConnectionManager();
            Connection conn = connection.getNewConnection();
            PreparedStatement st = conn.prepareStatement("INSERT INTO orders (client_id, book_id, order_date) VALUES ( ?, ?, ?)");
            int col = 1;
            st.setString(col, orders.getClientId());
            st.setString(++col, orders.getBookId());
            st.setString(++col,   orders.getOrderDate());
            st.executeUpdate();
            connection.closeConnection(conn);
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
            return orders;
    }
    public static Orders updateOrders(Orders orders) {

       try {
            ConnectionManager connection = new ConnectionManager();
            Connection conn = connection.getNewConnection();
            PreparedStatement st = conn.prepareStatement("UPDATE orders SET client_id = ?, "
                    + "book_id = ?, "
                    + "order_date = ? WHERE order_id = ?");
            int col = 1;
            st.setString(col, orders.getClientId());
            st.setString(++col, orders.getBookId());
            st.setString(++col,   orders.getOrderDate());
            st.setString(++col,   orders.getOrderId());
            st.executeUpdate();
            connection.closeConnection(conn);
        } catch (Exception e) {
           System.err.println("Got an exception! ");
           System.err.println(e.getMessage());
        }
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
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}