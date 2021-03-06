package edu.gatech.buzzmovieselector.server.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Configures and provides access to Hibernate sessions, tied to the
 * current thread of execution.  Follows the Thread Local Session
 * pattern, see
 * <a href="http://hibernate.org/42.html">http://hibernate.org/42.html</a>.
 */
public class HibernateSessionFactory {

    /**
     * Location of hibernate.cfg.xml file.
     * Location should be on the classpath as Hibernate uses
     * #resourceAsStream style lookup for its configuration file.
     * The default classpath location of the hibernate config file is
     * in the default package. Use #setConfigFile() to update
     * the location of the configuration file for the current session.
     */
    private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
    private static final ThreadLocal<Session> threadLocal = new
            ThreadLocal<Session>();
    private static org.hibernate.SessionFactory sessionFactory;
    private static String configFile = CONFIG_FILE_LOCATION;
    private static StandardServiceRegistryBuilder standardRegistryBuilder;

    static {
        rebuildSessionFactory();
    }

    private HibernateSessionFactory() {
    }

    /**
     * Returns the ThreadLocal Session instance.  Lazy initialize
     * the <code>SessionFactory</code> if needed.
     *
     * @return Session
     * @throws HibernateException
     */
    public static Session getSession() throws HibernateException {
        Session session = (Session) threadLocal.get();

        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
                rebuildSessionFactory();
            }
            session = (sessionFactory != null) ? sessionFactory.openSession()
                    : null;
            threadLocal.set(session);
        }

        return session;
    }

    /**
     * Rebuild hibernate session factory
     */
    public static void rebuildSessionFactory() {
        try {
            standardRegistryBuilder = new StandardServiceRegistryBuilder()
                    .configure(configFile);
            parseDBUri();
            Metadata metadata = new MetadataSources(standardRegistryBuilder
                    .build())
                    .getMetadataBuilder()
                    .build();

            sessionFactory = metadata.getSessionFactoryBuilder().build();
        } catch (Exception e) {
            System.err
                    .println("%%%% Error Creating SessionFactory %%%%");
            e.printStackTrace();
        }
    }

    /**
     * Parse database connection information
     *
     * @throws URISyntaxException the string cannot be parsed as URI
     */
    public static void parseDBUri() throws URISyntaxException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':'
                + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";
        standardRegistryBuilder.applySetting("hibernate.connection.username",
                username)
                .applySetting("hibernate.connection.password", password)
                .applySetting("hibernate.connection.url", dbUrl);
    }

    /**
     * Close the single hibernate session instance.
     *
     * @throws HibernateException
     */
    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }

    /**
     * return session factory
     */
    public static org.hibernate.SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * return session factory
     * <p>
     * session factory will be rebuilded in the next call
     */
    public static void setConfigFile(String configFile) {
        HibernateSessionFactory.configFile = configFile;
        sessionFactory = null;
    }

    /**
     * return Standard Registry Builder (the configuration)
     */
    public static StandardServiceRegistryBuilder getStandardRegistryBuilder() {
        return standardRegistryBuilder;
    }

}