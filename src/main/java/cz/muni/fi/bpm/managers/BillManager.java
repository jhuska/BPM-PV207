/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.bpm.managers;

import cz.muni.fi.bpm.model.Bill;
import java.util.Date;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author jhuska
 */
@Stateful
public class BillManager {

    @Inject
    private EntityManager em;
    
    @Inject
    private AppUserManager userManager;
    
    public void createBill(Bill bill) {
        bill.setCreated(new Date());
        em.persist(bill);
    }
    
    public Bill getBill(Long id) {
        return em.find(Bill.class, id);
    }
}