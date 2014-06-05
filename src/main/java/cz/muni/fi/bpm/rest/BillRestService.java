package cz.muni.fi.bpm.rest;

import cz.muni.fi.bpm.managers.BillManager;
import cz.muni.fi.bpm.model.AppUser;
import cz.muni.fi.bpm.model.Bill;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author jhuska
 */
@Path("/bills")
@RequestScoped
public class BillRestService {

    @Inject
    private BillManager billManager;
    
    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Bill lookupBill(@PathParam("id") long id) {
        Bill bill = billManager.getBill(id);
        if(bill == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return bill;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createBill(Bill bill) {
        try {
            billManager.createBill(bill);
        } catch (PersistenceException ex) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("There was an error thrown while persisting the entity: "
                            + ex.getMessage()).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(ex)
                    .build();
        }
        return Response.ok().build();
    }
}
