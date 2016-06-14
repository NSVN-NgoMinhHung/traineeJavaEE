/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author hungnm
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT c FROM Product c"),
    @NamedQuery(name = "Product.findById", query = "SELECT c FROM Product c WHERE c.id = :id"),
    @NamedQuery(name = "Product.findByName", query = "SELECT c FROM Product c WHERE c.productName = :productName"),
    @NamedQuery(name = "Product.findByDescription", query = "SELECT c FROM Product c WHERE c.description = :description"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT c FROM Product c WHERE c.price = :price")
    })
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;
    @ManyToOne
    private Genre genre;
    private String description;
    private float price;
    private String imageFileName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public Product() {
    }

    public Product( String productName, Genre genre, String description, float price, String imageFileName) {
        this.productName = productName;
        this.genre = genre;
        this.description = description;
        this.price = price;
        this.imageFileName = imageFileName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Product[ id=" + id + " ]";
    }

}
