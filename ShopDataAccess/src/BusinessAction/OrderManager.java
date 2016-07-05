/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessAction;

import DataAccess.DataFacade;
import entity.Order;

/**
 *
 * @author hungnm
 */
public class OrderManager {
    DataAccess.DataFacade df = new DataFacade();
    
    public void insertOrder(Order o){
        df.persist(o);
    }
    
    public void updateOrder(Long id, Order n){
        Object obj = df.findObjectById(id, n.getClass());
        Order o = (Order)obj;
        o.setCustomer(n.getCustomer());
        o.setDateCreated(n.getDateCreated());
        o.setDateShipped(n.getDateShipped());
        o.setStatus(n.getStatus());
        df.update();
    }
    
    public void  deleteOrder(Order o){
        df.delete(o);
    }
}
