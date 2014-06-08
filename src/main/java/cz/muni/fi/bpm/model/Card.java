package cz.muni.fi.bpm.model;

import java.util.Objects;
import javax.validation.constraints.Pattern;

/**
 *
 * @author jhuska
 */
public class Card {

    @Pattern(regexp = "[0-9]{16}")
    private String cardNumber;

    @Pattern(regexp = "[0-9]{3}")
    private String cvv;

    @Pattern(regexp = "0[1-9]|1[0-2]")
    private String validityMonth;

    @Pattern(regexp = "20[0-9]{2}")
    private String validityYear;

    public Card(String cardNumber, String cvv, String validityMonth, String validityYear) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.validityMonth = validityMonth;
        this.validityYear = validityYear;
    }

    public Card() {
    }

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.cardNumber);
        hash = 97 * hash + Objects.hashCode(this.cvv);
        hash = 97 * hash + Objects.hashCode(this.validityMonth);
        hash = 97 * hash + Objects.hashCode(this.validityYear);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if (!Objects.equals(this.cardNumber, other.cardNumber)) {
            return false;
        }
        if (!Objects.equals(this.cvv, other.cvv)) {
            return false;
        }
        if (!Objects.equals(this.validityMonth, other.validityMonth)) {
            return false;
        }
        if (!Objects.equals(this.validityYear, other.validityYear)) {
            return false;
        }
        return true;
    }

}
