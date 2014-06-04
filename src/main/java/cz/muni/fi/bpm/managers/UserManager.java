package cz.muni.fi.bpm.managers;

import cz.muni.fi.bpm.model.User;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateful
public class UserManager {

    @Inject
    private EntityManager em;
    
    public void banUser(long userId) {
        User userToBan = getUser(userId);
        userToBan.setBanned(true);
        em.merge(userToBan);
    }
    
    public User getUser(Long id) {
        return em.find(User.class, id);
    }

}
