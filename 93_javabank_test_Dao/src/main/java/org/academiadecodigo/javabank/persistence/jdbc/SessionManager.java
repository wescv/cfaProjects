package org.academiadecodigo.javabank.persistence.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SessionManager {

    private static final String DEFAULT_USER = "root";
    private static final String DEFAULT_PASS = "";
    private static final String DEFAULT_HOST = "localhost";
    private static final String DEFAULT_DB = "javabank";

    private static final String CONNECTOR = "jdbc:mysql:";

    private String dbUrl;
    private String user;
    private String pass;
    private Connection connection;

    public SessionManager(String user, String pass, String host, String database) {
        this.user = user;
        this.pass = pass;
        this.dbUrl = CONNECTOR + "//" + host + "/" + database;
    }

    public SessionManager() {
        this(DEFAULT_USER, DEFAULT_PASS, DEFAULT_HOST, DEFAULT_DB);
    }

    public void startConnection() {

        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(dbUrl, user, pass);
            }
        } catch (SQLException ex) {
            System.out.println("Failure to connect to database : " + ex.getMessage());
        }
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println("Failure to close database connections: " + ex.getMessage());
        }
    }

    public Connection getCurretnConnection() {
        startConnection();
        return connection;
    }
}
