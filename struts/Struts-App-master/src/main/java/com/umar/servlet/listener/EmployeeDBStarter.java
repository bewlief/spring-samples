package com.umar.servlet.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.h2.tools.Server;
import org.h2.util.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.h2.tools.Server.createTcpServer;

public class EmployeeDBStarter implements ServletContextListener {
    private static final Log log = LogFactory.getLog(EmployeeDBStarter.class);
    private Connection connection;
    private Server server;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        org.h2.Driver.load();
        // This will get the setting from a context-param in web.xml if
        // defined:
        ServletContext servletContext = servletContextEvent.getServletContext();
        String url = getParameter(servletContext, "db.url", "jdbc:h2:~/employees_db;mode=mysql");
        String user = getParameter(servletContext, "db.user", "sa");
        String password = getParameter(servletContext, "db.password", "sa");
        log.info(String.format("Using url: %s ", url));
        log.info(String.format("Using user: %s ", user));
        //Start the server if configured to do so.
        String serverParams = getParameter(servletContext, "db.tcpServer", null);
        if(null != serverParams) {
            String [] params = StringUtils.arraySplit(serverParams, ' ', true);
            try{
                log.info(String.format("Using params: %s ", params));
                server = createTcpServer(params);
                server.start();
                // To access the database in server mode, use the database URL:
                // jdbc:h2:tcp://localhost/~/employees_db
                connection = DriverManager.getConnection(url, user, password);
                servletContext.setAttribute("connection", connection);
                log.info("employees_db is up. Use jdbc:h2:tcp://localhost/~/employees_db;mode=mysql to connect.");
            }catch (SQLException ex) {
                log.error(ex);
                throw new RuntimeException("Exception occurred while creating TCP Server in EmployeeDBStarter. ", ex);
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        closeStatement();
        closeConnection();
        stopServer();
    }

    public Connection getConnection() {
        return connection;
    }

    private static String getParameter(ServletContext ctx, String key, String defaultValue) {
        String value = ctx.getInitParameter(key);
        return value == null ? defaultValue : value;
    }

    private void closeStatement() {
        try{
            Statement statement = connection.createStatement();
            statement.execute("SHUTDOWN");
            statement.close();
        }catch (SQLException ex) {
            log.error(ex);
            throw new RuntimeException("Exception occurred while creating Statement in EmployeeDBStarter. ", ex);
        }
    }

    private void closeConnection() {
        try{
            connection.close();
        }catch (SQLException ex) {
            log.error(ex);
            throw new RuntimeException("Exception occurred while closing Connection in EmployeeDBStarter. ", ex);
        }
    }

    private void stopServer() {
        if(null != server) {
            server.stop();
            server = null;
        }
    }
}
