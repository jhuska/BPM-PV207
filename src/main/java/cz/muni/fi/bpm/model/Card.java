/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.bpm.model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author jhuska
 */
public class Card {

    private String cardNumber;

    private Date validTill;

    private String csvNumber;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getValidTill() {
        return validTill;
    }

    public void setValidTill(Date validTill) {
        this.validTill = validTill;
    }

    public String getCsvNumber() {
        return csvNumber;
    }

    public void setCsvNumber(String csvNumber) {
        this.csvNumber = csvNumber;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.cardNumber);
        hash = 97 * hash + Objects.hashCode(this.validTill);
        hash = 97 * hash + Objects.hashCode(this.csvNumber);
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
        if (!Objects.equals(this.validTill, other.validTill)) {
            return false;
        }
        if (!Objects.equals(this.csvNumber, other.csvNumber)) {
            return false;
        }
        return true;
    }

}
