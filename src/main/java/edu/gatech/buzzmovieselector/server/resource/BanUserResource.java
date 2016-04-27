package edu.gatech.buzzmovieselector.server.resource;

import edu.gatech.buzzmovieselector.server.dao.UserDao;
import edu.gatech.buzzmovieselector.server.dao.impl.UserDaoImpl;
import edu.gatech.buzzmovieselector.server.entity.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("/banUser")
public class BanUserResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User banUser(User user) {
        User theUser = null;
        try {
            UserDao userDao = new UserDaoImpl();
            theUser = userDao.findById(user.getUsername());
            theUser.setUserStatus(User.UserStatus.BANNED);
            userDao.update(theUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return theUser;
    }
}
