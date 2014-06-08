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
public class DeliveryService {

    @XmlRootElement
    public static class OrderDelivered {

        @XmlValue
        public boolean delivered;

        public OrderDelivered() {
        }

        public OrderDelivered(boolean valid) {
            this.delivered = valid;
        }
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_XML)
    public OrderDelivered isOrderDelivered(@PathParam("id") long orderId) {
        return new OrderDelivered(orderId % 2 == 0);
    }

}
