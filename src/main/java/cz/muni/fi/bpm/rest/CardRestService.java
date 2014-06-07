package cz.muni.fi.bpm.rest;

import cz.muni.fi.bpm.managers.BillManager;
import cz.muni.fi.bpm.model.Card;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
    @Produces(MediaType.APPLICATION_XML)
    public boolean isCardValid(Card card) {
        return false;
    }
}