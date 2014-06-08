package cz.muni.fi.bpm.rest;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 *
 * @author <a href="mailto:jhuska@redhat.com">Juraj Huska</a>
 */
@Path("/delivery")
@RequestScoped
public class DeliveryEndpoint {

    @XmlRootElement
    public static class DeliveryResponse {

        @XmlValue
        public boolean delivered;

        public DeliveryResponse() {
        }

        public DeliveryResponse(boolean valid) {
            this.delivered = valid;
        }
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.TEXT_XML)
    public DeliveryResponse isOrderDelivered(@PathParam("id") long orderId) {
        return new DeliveryResponse(orderId % 2 == 0);
    }

}
