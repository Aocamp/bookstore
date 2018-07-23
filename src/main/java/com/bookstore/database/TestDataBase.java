package com.bookstore.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestDataBase {
    public static void main(String[] args) throws Exception {

        Statement st;
        ConnectionManager connection = new ConnectionManager();
        Connection conn = connection.getNewConnection();
        try {
            List al = null;
            String query =
                    "select books.book_id, books.book_name, authors.author_name, genres.genre_name, books.price from books INNER JOIN authors on books.author=authors.author_id INNER JOIN genres on books.genre=genres.genre_id";
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                al = new ArrayList();
                al.add(rs.getString(1));
                al.add(rs.getString(2));
                al.add(rs.getString(3));
                al.add(rs.getString(4));
                al.add(rs.getInt(5));
                System.out.println("al :: "+al);

            }
            st.close();
            System.out.println("Disconnected from database");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
