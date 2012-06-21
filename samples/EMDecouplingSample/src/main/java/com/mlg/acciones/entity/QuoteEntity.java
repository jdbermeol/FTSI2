package com.mlg.acciones.entity;

import com.mlg.acciones.vo.QuoteVo;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author josebermeo
 */
@javax.persistence.Entity(name = "Quote")
@NamedQuery(name = "getQuotesByStockId",
    query = "SELECT result FROM Quote result"
        +"WHERE result.stock.id = :stockId")
public class QuoteEntity implements Entity<QuoteVo>, Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double low;
    private double high;
    private double open_;
    private double close_;
    private double volume;
    @ManyToOne
    private DayEntity date_;
    @ManyToOne
    private StockEntity stock;

    public double getClose() {
        return close_;
    }

    public void setClose(double close) {
        this.close_ = close;
    }

    public DayEntity getDate_() {
        return date_;
    }

    public void setDate_(DayEntity date_) {
        this.date_ = date_;
    }



    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getOpen() {
        return open_;
    }

    public void setOpen(double open) {
        this.open_ = open;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
    
    public StockEntity getStock() {
        return stock;
    }

    public void setStock(StockEntity stock) {
        this.stock = stock;
    }
   @Override
    public QuoteVo toVo() {
        QuoteVo newVo = new QuoteVo();
        newVo.setId(this.getId());
        newVo.setClose(this.getClose());
        newVo.setDate(this.getDate_().getId());
        newVo.setHigh(this.getHigh());
        newVo.setLow(this.getLow());
        newVo.setOpen(this.getOpen());
        newVo.setVolume(this.getVolume());
        newVo.setStock(this.getStock().getId());
        return newVo;
    }
    
    
    
    
}
