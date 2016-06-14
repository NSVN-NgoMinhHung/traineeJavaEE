/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopdataaccess;

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
        Genre g1 = new Genre("Genre1", "good");
        Genre g2 = new Genre("Genre2", "normal");
        Genre g3 = new Genre("Genre3", "bad");
        da.persist(g1);
        da.persist(g2);
        da.persist(g3);
        Product p1 = new Product( "Product 1", g1, "sthing", 100, "http://placehold.it/350x260");
        Product p2 = new Product( "Product 2", g2, "sthing", 110, "http://placehold.it/350x260");
        Product p3 = new Product( "Product 3", g3, "sthing", 120, "http://placehold.it/350x260");
        Product p4 = new Product( "Product 4", g1, "sthing", 130, "http://placehold.it/350x260");
        Product p5 = new Product( "Product 5", g2, "sthing", 140, "http://placehold.it/350x260");
        Product p6 = new Product( "Product 6", g3, "sthing", 150, "http://placehold.it/350x260");
        Product p7 = new Product( "Product 7", g1, "sthing", 160, "http://placehold.it/350x260");
        Product p8 = new Product( "Product 8", g2, "sthing", 170, "http://placehold.it/350x260");
        Product p9 = new Product( "Product 9", g3, "sthing", 180, "http://placehold.it/350x260");
        Product p10 = new Product( "Product 10", g1, "sthing", 190, "http://placehold.it/350x260");
        Product p11 = new Product( "Product 11", g2, "sthing", 200, "http://placehold.it/350x260");
        Product p12 = new Product( "Product 12", g3, "sthing", 210, "http://placehold.it/350x260");
        da.persist(p1);
        da.persist(p2);
        da.persist(p3);
        da.persist(p4);
        da.persist(p5);
        da.persist(p6);
        da.persist(p7);
        da.persist(p8);
        da.persist(p9);
        da.persist(p10);
        da.persist(p11);
        da.persist(p12);
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
