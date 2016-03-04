package edu.gatech.buzzmovieselector.server;

import edu.gatech.buzzmovieselector.server.dao.HibernateSessionFactory;
import edu.gatech.buzzmovieselector.server.dao.UserDao;
import edu.gatech.buzzmovieselector.server.dao.impl.UserDaoImpl;
import edu.gatech.buzzmovieselector.server.entity.Profile;
import edu.gatech.buzzmovieselector.server.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() throws Exception {
        UserDao ud = new UserDaoImpl();
        User user = new User();
        user.setUsername("jed1");
        user.setPassword("jed");
        user.setUserLevel(User.UserLevel.USER);

        Profile profile = new Profile();
        profile.setEmail("jed@jedc.com");
        user.setProfile(profile);

        try {
            Configuration configuration = new Configuration();
            configuration = configuration.configure("/hibernate.cfg.xml");
            ServiceRegistry serviceRegistry = new
                    StandardServiceRegistryBuilder()
                    .applySettings(
                            configuration.getProperties()).build();
            //parseDBUri();
            System.err.println("shitty stuff");
//            SessionFactory sessionFactory = configuration.buildSessionFactory
//                    (serviceRegistry);
        } catch (Exception e) {
            System.err
                    .println("%%%% Error Creating SessionFactory %%%%");
            e.printStackTrace();
        }

        //ProfileDao pd = new ProfileDaoImpl();

        HibernateSessionFactory.getSession();

//        pd.createOrUpdate(profile);
//        ud.createOrUpdate(user);
        return "Hello, Heroku!";
    }
}
