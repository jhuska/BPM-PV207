package cz.muni.fi.bpm.rest;

import cz.muni.fi.bpm.model.Card;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 *
 * @author jhuska
 */
@Path("/card")
@RequestScoped
public class CardEndpoint {

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class CardRequest {

        @XmlElement
        private String cardNumber;

        @XmlElement
        private String cvv;

        @XmlElement
        private String validityMonth;

        @XmlElement
        private String validityYear;

        public String getCardNumber() {
            return cardNumber;
        }

        public void setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        public String getCvv() {
            return cvv;
        }

        public void setCvv(String cvv) {
            this.cvv = cvv;
        }

        public String getValidityMonth() {
            return validityMonth;
        }

        public void setValidityMonth(String validityMonth) {
            this.validityMonth = validityMonth;
        }

        public String getValidityYear() {
            return validityYear;
        }

        public void setValidityYear(String validityYear) {
            this.validityYear = validityYear;
        }

    }

    @XmlRootElement
    public static class CardResponse {

        @XmlValue
        public boolean valid;

        public CardResponse() {
        }

        public CardResponse(boolean valid) {
            this.valid = valid;
        }
    }

    @PUT
    @Path("/isValid")
    @Produces(MediaType.TEXT_XML)
    @Consumes(MediaType.TEXT_XML)
    public CardResponse isCardValid(CardRequest req) {

        // validate the passed parameters using Bean Validation
        Card card = new Card(req.getCardNumber(), req.getCvv(), req.getValidityMonth(), req.getValidityYear());
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Card>> violations = validator.validate(card);

        return new CardResponse(violations.isEmpty());

    }

}
