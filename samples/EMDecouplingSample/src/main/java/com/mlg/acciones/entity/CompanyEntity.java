package com.mlg.acciones.entity;

import com.mlg.acciones.vo.CompanyVo;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author josebermeo
 */
@javax.persistence.Entity(name = "Company")
@NamedQueries({
    @NamedQuery(name = "getAllCompanies",
    query = "SELECT result FROM Company result"),
    @NamedQuery(name = "getCompaniesByMarketId",
    query = "SELECT result FROM Company result "
    + "WHERE result.MarketEntity.id = :marketId")
})
public class CompanyEntity implements Entity<CompanyVo>, Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String symbol;
    private String description;
    @ManyToOne
    private MarketEntity market;

    
    @Override
    public CompanyVo toVo() {
        CompanyVo newVo = new CompanyVo();
        newVo.setId(this.getId());
        newVo.setDescription(this.getDescription());
        newVo.setName(this.getName());
        newVo.setMarket(this.getMarket().getId());
        newVo.setSymbol(this.getSymbol());
        return newVo;
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

    public MarketEntity getMarket() {
        return market;
    }

    public void setMarket(MarketEntity market) {
        this.market = market;
    }

    
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    
    

    
    
    
     
}
