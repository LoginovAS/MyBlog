package org.sbx.dao.util;

import org.sbx.dao.enums.ConnectionProperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by isilme on 4/14/17.
 */
public class ConnectionFactory {

    private Connection connection;
    private String driver;
    private String url;
    private String user;
    private String password;

    public ConnectionFactory(){
        driver = ConnectionProperty.DRIVER.toString();
        url = ConnectionProperty.URL.toString();
        user = ConnectionProperty.NAME.toString();
        password = ConnectionProperty.PASSWORD.toString();
    }

    public Connection getConnection() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
        } catch (ClassNotFoundException ex){
            System.out.println("Cannot load driver: " + driver);
            System.out.println(ex);
        }

        return connection;
    }

}
