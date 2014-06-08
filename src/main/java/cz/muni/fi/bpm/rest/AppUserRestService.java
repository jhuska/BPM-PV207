package cz.muni.fi.bpm.rest;

import cz.muni.fi.bpm.managers.AppUserManager;
import cz.muni.fi.bpm.model.AppUser;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
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
@Path("/user")
@RequestScoped
public class AppUserRestService {
    
    @Inject
    private AppUserManager userManager;
    
    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_XML)
    public AppUser lookupUser(@PathParam("id") long id) {
        AppUser user = userManager.getUser(id);
        if(user == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return user;
    }
    
    @PUT
    @Path("/ban/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_XML)
    public Response banUser(@PathParam("id") long id, @FormParam("reason") String reason) {
        userManager.banUser(id);
        return Response.ok().build();
    }
    
    @GET
    @Path("/isBanned/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_XML)
    public boolean isAppUserBanned(@PathParam("id") long id) {
        return false;
    }
    
    @GET
    @Path("/hasViolations/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_XML)
    public boolean hasAppUserViolations(@PathParam("id") long id) {
        return false;
    }
    
    @PUT
    @Path("/addViolation/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_XML)
    public Response addViolation(@PathParam("id") long id, @FormParam("reason") String reason) {
        return Response.ok().build();
    }
    
}
