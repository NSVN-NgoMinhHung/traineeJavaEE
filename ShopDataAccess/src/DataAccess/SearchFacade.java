/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

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
    public List<Product> getAllProducts(){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ShopDataAccessPU");
        EntityManager enManager = emFactory.createEntityManager();
        Query query = enManager.createNamedQuery("Product.findAll");
        List<Product> result = query.getResultList();
        enManager.close();
        emFactory.close();
        return result;
    }
    public List<Product> getProductsByName(String name){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ShopDataAccessPU");
        EntityManager enManager = emFactory.createEntityManager();
        Query query = enManager.createNamedQuery("Product.findByName", String.class);
        query.setParameter("productName", name);
        List<Product> result = query.getResultList();
        enManager.close();
        emFactory.close();
        return result;
    }
    public List<Product> getProductsByKeyword(String keyword){
        return null;
    }
    
    public List<Product> getProductsByGenre(String name){
        return null;
    }
    
    public List<Product> getProductsByPrice(float min, float max){
        return null;
    }
}
