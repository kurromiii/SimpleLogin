package com.mftplus.simplelogin.model.utils;

import java.sql.Connection;
import java.sql.DriverManager;


public class JdbcProvider {
    private static final JdbcProvider jdbcProvider = new JdbcProvider();

    private JdbcProvider() {
    }

    public static JdbcProvider getJdbcProvider() {
        return jdbcProvider;
    }

    public Connection getConnection() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "login",
                "login");

    }
}
