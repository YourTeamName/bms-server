package edu.gatech.buzzmovieselector.server.resource;

import edu.gatech.buzzmovieselector.server.dao.UserDao;
import edu.gatech.buzzmovieselector.server.dao.impl.UserDaoImpl;
import edu.gatech.buzzmovieselector.server.entity.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/userList")
public class UserListResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUserList() {
        List<User> userList = null;
        try {
            UserDao userDao = new UserDaoImpl();
            userList = userDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
