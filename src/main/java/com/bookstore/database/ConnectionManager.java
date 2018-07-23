package com.bookstore.database;

import java.sql.Connection;
import java.sql.DriverManager;

    public class ConnectionManager {
        public Connection getNewConnection() throws Exception{
            Connection conn = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new Exception("No database");
            }

            String connectionURL = "jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false";
            conn = DriverManager.getConnection(connectionURL, "root", "root");
            return conn;
        }

        public void closeConnection(Connection conn) throws Exception{
            conn.close();

        }
    }



