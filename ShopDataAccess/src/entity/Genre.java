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

/**
 *
 * @author hungnm
 */
@Entity
public class Genre implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String genreName;
    private String description;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public String getDescription() {
        return description;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Genre() {
    }

    public Genre(String genreName, String description) {
        this.genreName = genreName;
        this.description = description;
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
        if (!(object instanceof Genre)) {
            return false;
        }
        Genre other = (Genre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Genre[ id=" + id + ", name="+ genreName +", description="+description +" ]";
    }
    
}
