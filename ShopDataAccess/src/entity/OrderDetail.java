/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author hungnm
 */
@Entity
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @OneToOne
    private Order order;
    @Id
    @ManyToOne   
    private Product product;
    private int quantity;
    private float unitCost;
    private float subTotal;

    public Order getId() {
        return order;
    }

    public void setId(Order id) {
        this.order = id;
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getUnitCost() {
        return unitCost;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnitCost(float unitCost) {
        this.unitCost = unitCost;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public OrderDetail() {
    }

    public OrderDetail(Order order, Product product, int quantity, float unitCost, float subTotal) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.unitCost = unitCost;
        this.subTotal = subTotal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (order != null ? order.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetail)) {
            return false;
        }
        OrderDetail other = (OrderDetail) object;
        if ((this.order == null && other.order != null) || (this.order != null && !this.order.equals(other.order))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrderDetail[ id=" + order + " ]";
    }
    
}
