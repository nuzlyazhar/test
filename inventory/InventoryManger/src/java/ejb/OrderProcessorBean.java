/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Order;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nuzly
 */
@Stateless
public class OrderProcessorBean {
    
    @PersistenceContext
    EntityManager em;

    public Order createOrder(Order order) {
        Order ord = em.merge(order);
        return ord;
    }

}
