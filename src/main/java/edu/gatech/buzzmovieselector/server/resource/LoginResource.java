package edu.gatech.buzzmovieselector.server.resource;

import com.fasterxml.jackson.databind.JsonNode;
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

@Path("/login")
public class LoginResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User login(JsonNode json) {
        String username = json.get("username").asText();
        String password = json.get("password").asText();
        User user = null;
        try {
            UserDao userDao = new UserDaoImpl();
            user = userDao.findById(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user == null || !user.getPassword().equals(password)) {
            user = null;
        }
        return user;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getlogin() {
        User user = null;
        try {
            UserDao userDao = new UserDaoImpl();
            user = userDao.findById("user");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


}
