package cz.muni.fi.bpm.managers;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateful
public class UserAccountManager {

    @PersistenceContext
    private EntityManager em;

}
