/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import entity.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author hungnm
 */
public class DataFacade {

    public void persist(Object object) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ShopDataAccessPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Object findObjectById(long id, Class<?> type) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ShopDataAccessPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Object o = em.find(type, id);
            return o;
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return null;
    }

    public void update() {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ShopDataAccessPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void delete(Object object) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ShopDataAccessPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.remove(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
