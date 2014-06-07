package cz.muni.fi.bpm.rest;

import cz.muni.fi.bpm.managers.CategoryService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author <a href="mailto:jhuska@redhat.com">Juraj Huska</a>
 */
@Path("/category")
@RequestScoped
public class MarketplaceCategoryEndpoint {
    
    @Inject
    private CategoryService service;
            
    @PUT
    @Path("/suggest")
    @Produces(MediaType.APPLICATION_XML)
    public Response suggestCategory(@FormParam("title") String title, @FormParam("description") String description) {
        return Response.ok(service.suggestCategory(title, description)).build();
    }
    
}
