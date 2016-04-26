package edu.gatech.buzzmovieselector.server.resource;

import com.fasterxml.jackson.databind.JsonNode;
import edu.gatech.buzzmovieselector.server.entity.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/banUser")
public class BanUserResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User login(JsonNode json) {
        return null;
    }
}
