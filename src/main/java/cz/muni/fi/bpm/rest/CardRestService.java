package cz.muni.fi.bpm.rest;

import cz.muni.fi.bpm.model.Card;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 *
 * @author jhuska
 */
@Path("/card")
@RequestScoped
public class CardRestService {

    @XmlRootElement
    public static class CardValid {

        @XmlValue
        public boolean valid;

        public CardValid() {
        }

        public CardValid(boolean valid) {
            this.valid = valid;
        }
    }

    @PUT
    @Path("/isValid")
    @Produces(MediaType.APPLICATION_XML)
    public CardValid isCardValid(
            @FormParam("cardNr") String cardNumber,
            @FormParam("cvv") String cvv,
            @FormParam("validityMonth") String validityMonth,
            @FormParam("validityYear") String validityYear) {

        // validate the passed parameters using Bean Validation
        Card card = new Card(cardNumber, cvv, validityMonth, validityYear);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Card>> violations = validator.validate(card);

        return new CardValid(violations.isEmpty());

    }

}
