/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author cld
 */
public class CartTable {
    public static List<Shoppingcart> findAllProducts() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingPU");
        EntityManager em = emf.createEntityManager();
        List<Shoppingcart> pdList = null;
        try {
            pdList = (List<Shoppingcart>) em.createNamedQuery("Shoppingcart.findAll").getResultList();         
        } catch (Exception e) {
            throw new RuntimeException(e);
            
        }
        finally {
            em.close();
            emf.close();
        }
        return pdList;
    }
    public static int insertCart(Shoppingcart emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Products target = em.find(Products.class, emp.getProducts().getId());
            if (target == null) {
                return 0;
            }
            em.persist(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return 0;
        }
        finally {
            em.close();
            emf.close();
        }
        return 1;
    }
    public static int lastId() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingPU");
        EntityManager em = emf.createEntityManager();
        int last = 0;
        List<Shoppingcart> shoppingCartList = null;
        try{
            shoppingCartList = (List<Shoppingcart>) em.createNamedQuery("Shoppingcart.findAll").getResultList();
            for(Shoppingcart spCart : shoppingCartList){
                if(spCart.getShoppingcartPK().getCartId() > last){
                    last = spCart.getShoppingcartPK().getCartId();
                }
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            em.close();
            emf.close();
        }
        return last;
    }
}
