/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mlg.acciones.vo;

import java.util.List;

/**
 *
 * @author josebermeo
 */
public class MarketVo extends ValueObject {
    
    private Integer id;
    private String name;
    private String nemo;
    private String description;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MarketVo other = (MarketVo) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.nemo == null) ? (other.nemo != null) : !this.nemo.equals(other.nemo)) {
            return false;
        }
        if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 29 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 29 * hash + (this.nemo != null ? this.nemo.hashCode() : 0);
        hash = 29 * hash + (this.description != null ? this.description.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "MarketVo{" + "id=" + id + ", name=" + name + ", nemo=" + nemo + ", description=" + description + '}';
    }

    


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNemo() {
        return nemo;
    }

    public void setNemo(String nemo) {
        this.nemo = nemo;
    }
    
    
    
    
}
