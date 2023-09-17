package com.umar.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConnectionManager implements AutoCloseable {

    private Connection connection;
    private static final JdbcConnectionManager SINGLETON = new JdbcConnectionManager();

    private JdbcConnectionManager() {
        synchronized (this) {
            try {
                Properties props = getConnectionProperties();
                String url = props.getProperty("jdbc.url");
                String user = "admin";
                String passwd = "admin";
                Class.forName(props.getProperty("jdbc.driverClassName"));
                connection = DriverManager.getConnection(url, user, passwd);
                connection.setAutoCommit(false);
            } catch (ClassNotFoundException | SQLException | IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static JdbcConnectionManager getJdbcUtil() {
        return SINGLETON;
    }

    public Connection getConnection() {
        return connection;
    }

    public void commit() {
        try {
            if (!isActiveConnection()) {
                throw new RuntimeException("No Active Connection Available");
            }
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void rollback() {
        try {
            if (!isActiveConnection()) {
                throw new RuntimeException("No Active Connection Available");
            }
            connection.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            if (!isActiveConnection()) {
                throw new RuntimeException("No Active Connection Available");
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isActiveConnection() {
        try {
            return (null != connection && !connection.isClosed());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Properties getConnectionProperties() throws IOException, URISyntaxException {
        //URL url = getClass().getProtectionDomain().getCodeSource().getLocation();
        //String applicationDir = url.getPath();
        Properties props = new Properties();
        props.setProperty("jdbc.driverClassName","org.h2.Driver");
        props.setProperty("jdbc.url", "jdbc:h2:tcp://localhost/~/employees_db;mode=mysql");
        props.setProperty("user.name","sa");
        props.setProperty("jdbc.password", "sa");
        //props.load(new FileInputStream(applicationDir + "com/umar/jdbc/h2db.properties"));
        return props;
    }
}