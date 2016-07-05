/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author hungnm
 */
public class DataFacade {

    private final EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ShopDataAccessPU");
    private final EntityManager em = emf.createEntityManager();

    public void persist(Object object) {

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
