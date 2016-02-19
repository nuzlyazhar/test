/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Item;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author nuzly
 */
@Stateless
public class ItemManagementBean {

    @PersistenceContext
    EntityManager em;

    public Item createItem(Item item) {
        Item i = em.merge(item);
        em.flush();;
        return i;

    }

    public List<Item> findAllItems() {
        List<Item> itemsList = em.createNamedQuery("Item.findAll", Item.class).getResultList();
        return itemsList;

    }

    public Item getItemById(String id) {
        Item item = em.createNamedQuery("Item.findById", Item.class).getSingleResult();
        return item;

    }

    public List<Item> searchItems(Item item) {

        TypedQuery<Item> query = em.createQuery("SELECT i FROM Item i WHERE UPPER(i.itemName) LIKE :keyword ORDER BY i.itemName", Item.class);
        query.setParameter("keyword", "%" + item.getItemName().toUpperCase() + "%");
        List<Item> itemResults = query.getResultList();
        return itemResults;

    }
    
      public Item searchItemByName(String itemName) {

        TypedQuery<Item> query = em.createNamedQuery("Item.findByItemName", Item.class);
        query.setParameter("itemName", itemName);
        Item itemResults = query.getSingleResult();
        return itemResults;

    }
      
      

}
