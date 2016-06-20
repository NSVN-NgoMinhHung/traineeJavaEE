/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopdataaccess;

import DataAccess.DataFacade;
import DataAccess.SearchFacade;
import entity.Administrator;
import entity.Genre;
import entity.Product;
import entity.Users;
import java.util.List;
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
        DataAccess.DataFacade df = new DataFacade();
        Object g = df.findObjectById(1, Genre.class);
        System.out.println(g.toString());
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
