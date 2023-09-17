package com.umar.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfo;

@WebListener
public class FlywayMigrationListener implements ServletContextListener {
    private static final Log log = LogFactory.getLog(FlywayMigrationListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info(String.format("Initializing ...%s", FlywayMigrationListener.class.getCanonicalName()) );
        String url = "jdbc:h2:tcp://localhost/~/employees_db;mode=mysql";
        String user = "sa";
        String password = "sa";
        String location = "filesystem:src/main/resources/flyway/migrations";
        Flyway flyway = Flyway.configure().dataSource(url, user, password).locations(location).load();
        flyway.migrate();
        MigrationInfo[] infos = flyway.info().all();
        for (MigrationInfo info : infos) {
            log.info(String.format("%s\t%-20s\t%s", info.getVersion(), info.getState(), info.getDescription()));
        }
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info(String.format("Destroying ...%s", FlywayMigrationListener.class.getCanonicalName()) );
    }

}
