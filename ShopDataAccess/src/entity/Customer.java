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

/**
 *
 * @author hungnm
 */
@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @ManyToOne
    private Users user;
    private String customerName;
    private String address;
    private String email;
    private String phoneno;
    private String creaditcardInfo;
    private String shippingInfo;

    public Users getId() {
        return user;
    }

    public void setId(Users id) {
        this.user = id;
    }

    public Users getUser() {
        return user;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public String getCreaditcardInfo() {
        return creaditcardInfo;
    }

    public String getShippingInfo() {
        return shippingInfo;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public void setCreaditcardInfo(String creaditcardInfo) {
        this.creaditcardInfo = creaditcardInfo;
    }

    public void setShippingInfo(String shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public Customer() {
    }

    public Customer(Users user, String customerName, String address, String email, String phoneno, String creaditcardInfo, String shippingInfo) {
        this.user = user;
        this.customerName = customerName;
        this.address = address;
        this.email = email;
        this.phoneno = phoneno;
        this.creaditcardInfo = creaditcardInfo;
        this.shippingInfo = shippingInfo;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (user != null ? user.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.user == null && other.user != null) || (this.user != null && !this.user.equals(other.user))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Customer[ id=" + user + " ]";
    }
    
}
