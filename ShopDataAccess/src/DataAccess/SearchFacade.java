/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import entity.Genre;
import entity.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author hungnm
 */
public class SearchFacade {

    public List<Product> getAllProducts() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ShopDataAccessPU");
        EntityManager enManager = emFactory.createEntityManager();
        Query query = enManager.createNamedQuery("Product.findAll");
        List<Product> result = query.getResultList();
        enManager.close();
        emFactory.close();
        return result;
    }

    public List<Product> getProductsByName(String name) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ShopDataAccessPU");
        EntityManager enManager = emFactory.createEntityManager();
        Query query = enManager.createNamedQuery("Product.findByName", String.class);
        query.setParameter("productName", "%" + name + "%");
        List<Product> result = query.getResultList();
        enManager.close();
        emFactory.close();
        return result;
    }

    public List<Product> getProductsById(int id) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ShopDataAccessPU");
        EntityManager enManager = emFactory.createEntityManager();
        Query query = enManager.createNamedQuery("Product.findById", String.class);
        query.setParameter("id", id);
        List<Product> result = query.getResultList();
        enManager.close();
        emFactory.close();
        return result;
    }

    public List<Product> getProductsByKeyword(String keyword) {
        return null;
    }

    public List<Product> getProductsByGenre(Long genreId) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ShopDataAccessPU");
        EntityManager enManager = emFactory.createEntityManager();
        Query query = enManager.createNamedQuery("Product.findByGenre", String.class);
        DataFacade df = new DataFacade();
        Object g = df.findObjectById(genreId, Genre.class);
        query.setParameter("genre", g);
        List<Product> result = query.getResultList();
        enManager.close();
        emFactory.close();
        return result;
    }

    public List<Product> getProductsByPrice(float min, float max) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ShopDataAccessPU");
        EntityManager enManager = emFactory.createEntityManager();
        Query query = enManager.createNamedQuery("Product.findByPrice", String.class);
        query.setParameter("minprice", min);
        query.setParameter("maxprice", max);
        List<Product> result = query.getResultList();
        enManager.close();
        emFactory.close();
        return result;
    }
}
