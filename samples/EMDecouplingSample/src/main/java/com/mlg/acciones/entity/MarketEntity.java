package com.mlg.acciones.entity;

import com.mlg.acciones.vo.MarketVo;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author josebermeo
 */
@javax.persistence.Entity(name = "Market")
public class MarketEntity implements Entity<MarketVo,Integer>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String nemo;
    private String description;



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

    @Override
    public MarketVo toVo() {
        MarketVo newVo= new MarketVo();
        newVo.setId(this.getId());
        
        newVo.setDescription(this.getDescription());
        newVo.setName(this.getName());
        newVo.setNemo(this.getNemo());
        
        return newVo;
    }

    
    
    
}
