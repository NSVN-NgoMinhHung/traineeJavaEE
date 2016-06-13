/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopdataaccess;

import entity.Administrator;
import entity.Genre;
import entity.Users;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hungnm
 */
public class ShopDataAccess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ShopDataAccess da = new ShopDataAccess();
        Users u = new Users("a", "a");
        da.persist(u);
        Administrator a = new Administrator(u, "a", "a");
        da.persist(a);
    }

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

}
