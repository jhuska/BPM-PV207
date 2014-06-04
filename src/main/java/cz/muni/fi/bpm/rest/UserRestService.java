package cz.muni.fi.bpm.rest;

import cz.muni.fi.bpm.managers.UserManager;
import cz.muni.fi.bpm.model.User;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author <a href="mailto:jhuska@redhat.com">Juraj Huska</a>
 */
@Path("/users")
@RequestScoped
public class UserRestService {
    
    @Inject
    private UserManager userManager;
    
    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public User lookupUser(@PathParam("id") long id) {
        User user = userManager.getUser(id);
        if(user == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return user;
    }
}
