package pl.listener;

//import java.util.Date;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import pl.config.DBManager;


public class SailingContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        DBManager.getManager().createEntityManagerFactory();}

    public void contextDestroyed(ServletContextEvent sce) {
        DBManager.getManager().closeEntityManagerFactory();    }}
