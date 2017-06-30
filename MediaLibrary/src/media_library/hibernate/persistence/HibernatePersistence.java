package media_library.hibernate.persistence;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernatePersistence {

private static final SessionFactory sessionFactory = buildSessionFactory();

 private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xm
            return new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }

        public static SessionFactory getSessionFactory() {
            return sessionFactory;
        }

        public static void shutdown() {
            // Close caches and connection pools
            getSessionFactory().close();
        }
   }
