package edu.gatech.buzzmovieselector.server.resource;

import edu.gatech.buzzmovieselector.server.dao.UserDao;
import edu.gatech.buzzmovieselector.server.dao.impl.UserDaoImpl;
import edu.gatech.buzzmovieselector.server.entity.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("/register")
public class RegisterResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User register(User user) {
        User newUser = null;
        try {
            UserDao userDao = new UserDaoImpl();
            userDao.createOrUpdate(user);
            newUser = userDao.findById(user.getUsername());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newUser;
    }
}
