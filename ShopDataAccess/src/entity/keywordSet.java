/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author hungnm
 */
@Entity
public class keywordSet implements Serializable {

    @Id
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String id) {
        this.keyword = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (keyword != null ? keyword.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof keywordSet)) {
            return false;
        }
        keywordSet other = (keywordSet) object;
        if ((this.keyword == null && other.keyword != null) || (this.keyword != null && !this.keyword.equals(other.keyword))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.keywordSet[ id=" + keyword + " ]";
    }
    
}
