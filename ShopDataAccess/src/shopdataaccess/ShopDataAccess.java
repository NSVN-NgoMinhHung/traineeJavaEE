/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopdataaccess;

import DataAccess.DataFacade;
import BusinessAction.SearchFacade;
import entity.Administrator;
import entity.Customer;
import entity.Genre;
import entity.Order;
import entity.Product;
import entity.ShippingInfo;
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
        DataFacade  df = new DataFacade();
        df.persist(new Customer((Users)df.findObjectById(1, Users.class), "Jason", "Ha Noi", "jason@jason.com", "01234564879", "0123456789", (ShippingInfo)df.findObjectById(51, ShippingInfo.class)));
    }

}
