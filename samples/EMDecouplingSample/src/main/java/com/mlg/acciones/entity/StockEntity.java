package com.mlg.acciones.entity;

import com.mlg.acciones.vo.StockVo;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author josebermeo
 */
@javax.persistence.Entity(name = "Stock")
@NamedQuery(name = "getStocksByCompanyId",
    query = "SELECT result FROM Stock result"
        +"WHERE result.company.id = :companyId")
public class StockEntity implements Entity<StockVo>, Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String symbol;
    private String description;
    @ManyToOne
    private CompanyEntity company;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }
    
    

    @Override
    public StockVo toVo() {
        StockVo newVo = new StockVo();
        newVo.setId(this.getId());
        newVo.setDescription(this.getDescription());
        newVo.setName(this.getName());
        newVo.setSymbol(this.getSymbol());
        newVo.setCompany(this.getCompany().getId());
        return newVo;
        
    }

    
   
    
    
    
}
