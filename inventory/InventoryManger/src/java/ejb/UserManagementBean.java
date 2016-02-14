/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import utills.Constants;

/**
 *
 * @author nuzly
 */
@Stateless
public class UserManagementBean {

    @PersistenceContext
    EntityManager em;

    public void createUser(User u) {
        System.out.println(u);
        em.merge(u);
        em.flush();

    }

    public User findByUsername(String userName) {
        Query query = em.createQuery("SELECT u FROM User u WHERE u.username = ?1 ");
        query.setParameter(1, userName);
        try {
            User u = (User) query.getSingleResult();
            return u;
        } catch (Exception e) {
            return null;
        }

    }

    public boolean validateUser(User u, String password) {
        boolean valid = false;
        if (password != null && password.equals(u.getPassword())) {
            if (Constants.APPROVED.equals(u.getStatus())) {
                valid = true;
            }
        }
        return valid;
    }

    //Used by sys admin
    public List<User> usersPendingApproval() {
        Query query = em.createQuery("SELECT u FROM User u WHERE u.status <> ?1 OR u.status is null ");
        query.setParameter(1, Constants.APPROVED);

        List<User> usersPendingApproval = query.getResultList();
        return usersPendingApproval;

    }
    
    public void approveUser(String id){
        User user = em.find(User.class, Integer.valueOf(id));
        user.setStatus(Constants.APPROVED);
        user.setRole(Constants.STAFF_ROLE);
        em.merge(user);
        em.flush();;
    
    }
    
   
}
