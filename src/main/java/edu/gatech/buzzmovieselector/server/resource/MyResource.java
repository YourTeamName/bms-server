package edu.gatech.buzzmovieselector.server.resource;

import edu.gatech.buzzmovieselector.server.dao.HibernateSessionFactory;
import edu.gatech.buzzmovieselector.server.dao.ProfileDao;
import edu.gatech.buzzmovieselector.server.dao.UserDao;
import edu.gatech.buzzmovieselector.server.dao.impl.ProfileDaoImpl;
import edu.gatech.buzzmovieselector.server.dao.impl.UserDaoImpl;
import edu.gatech.buzzmovieselector.server.entity.Profile;
import edu.gatech.buzzmovieselector.server.entity.User;

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
    @Produces(MediaType.APPLICATION_JSON)
    public User getIt() throws Exception {
        UserDao ud = new UserDaoImpl();
        User user = new User();
//        user.setUsername("jed1");
//        user.setPassword("jed");
//        user.setUserLevel(User.UserLevel.USER);
//
//        Profile profile = new Profile();
//        profile.setEmail("jed@jedc.com");
//        user.setProfile(profile);
//
//
//        ProfileDao pd = new ProfileDaoImpl();
//
//        HibernateSessionFactory.getSession();
//
//        pd.createOrUpdate(profile);
//        ud.createOrUpdate(user);
        user.getUsername();
        user.setUsername("shit");
        user.setUsername(null);
        return user;
    }
}
