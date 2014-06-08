package cz.muni.fi.bpm.services;

import cz.muni.fi.bpm.model.AppUser;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;


@Stateful
public class AppUserService {

    @Inject
    private EntityManager em;
    
    public void banUser(long userId) {
        AppUser userToBan = getUser(userId);
        userToBan.setBanned(true);
        em.merge(userToBan);
    }
    
    public AppUser getUser(Long id) {
        return em.find(AppUser.class, id);
    }

}
