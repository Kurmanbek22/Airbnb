package peaksoft.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.entity.*;

import java.util.Properties;

public class HibernateConfig {
    public static EntityManager getEntityManager() {

        try {
            Properties properties = new Properties();
            properties.put(Environment.JAKARTA_JDBC_DRIVER, "org.postgresql.Driver");
            properties.put(Environment.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost:5432/postgres");
            properties.put(Environment.JAKARTA_JDBC_USER, "postgres");
            properties.put(Environment.JAKARTA_JDBC_PASSWORD, "1234");
            properties.put(Environment.HBM2DDL_AUTO, "create");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
            properties.put(Environment.SHOW_SQL, "true");

            Configuration configuration = new Configuration();
            configuration.setProperties(properties);
            configuration.addAnnotatedClass(Address.class);
            configuration.addAnnotatedClass(Agency.class);
            configuration.addAnnotatedClass(Customer.class);
            configuration.addAnnotatedClass(House.class);
            configuration.addAnnotatedClass(RentInfo.class);
            configuration.addAnnotatedClass(Owner.class);
            return configuration.buildSessionFactory().createEntityManager();

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}

