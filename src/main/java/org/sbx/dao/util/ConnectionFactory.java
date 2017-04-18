package org.sbx.dao.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final Logger LOGGER = LogManager.getLogger(ConnectionFactory.class);

    private static final String CANNOT_LOAD_DRIVER_LOG_MESSAGE = "Cannot load driver: {}.";

    private static final String DRIVER = "com.jdbc.mysql.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/blog";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private Connection connection;
    private String driver;
    private String url;
    private String user;
    private String password;

    public ConnectionFactory(){
        driver = DRIVER;
        url = URL;
        user = USERNAME;
        password = PASSWORD;
    }

    public Connection getConnection() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
        } catch (ClassNotFoundException ex){
            LOGGER.error(CANNOT_LOAD_DRIVER_LOG_MESSAGE, driver);
            LOGGER.trace(ex);
        }

        return connection;
    }

}
