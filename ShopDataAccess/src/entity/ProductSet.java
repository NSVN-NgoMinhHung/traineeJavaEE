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

/**
 *
 * @author hungnm
 */
@Entity
public class ProductSet implements Serializable {

    @Id
    @ManyToOne
    private keywordSet keywordSet;
    @Id
    @ManyToOne
    private Product product;

    public keywordSet getKeywordSet() {
        return keywordSet;
    }

    public Product getProduct() {
        return product;
    }

    public void setKeywordSet(keywordSet keywordSet) {
        this.keywordSet = keywordSet;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductSet() {
    }

    public ProductSet(keywordSet keywordSet, Product product) {
        this.keywordSet = keywordSet;
        this.product = product;
    }
    
    
}
