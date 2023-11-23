package com.mftplus.simplelogin.model.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcProvider {
    private static final JdbcProvider jdbcProvider = new JdbcProvider();

    private JdbcProvider() {
    }

    public static JdbcProvider getJdbcProvider() {
        return jdbcProvider;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "javaee",
                "java123");

    }
}
