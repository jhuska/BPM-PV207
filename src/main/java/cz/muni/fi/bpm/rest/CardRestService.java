package cz.muni.fi.bpm.rest;

import cz.muni.fi.bpm.managers.BillManager;
import cz.muni.fi.bpm.model.AppUser;
import cz.muni.fi.bpm.model.Bill;
import cz.muni.fi.bpm.model.Card;
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
@Path("/cards")
@RequestScoped
public class CardRestService {

    @Inject
    private BillManager billManager;
    
    @POST
    @Path("/isValid")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean isCardValid(Card card) {
        return false;
    }
}