/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mlg.acciones.vo;

/**
 *
 * @author josebermeo
 */
public class QuoteVo extends ValueObject{
    
    private Integer id;
    private double low;
    private double high;
    private double open;
    private double close;
    private double volume;
    private Integer date;
    private Integer stock;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final QuoteVo other = (QuoteVo) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (Double.doubleToLongBits(this.low) != Double.doubleToLongBits(other.low)) {
            return false;
        }
        if (Double.doubleToLongBits(this.high) != Double.doubleToLongBits(other.high)) {
            return false;
        }
        if (Double.doubleToLongBits(this.open) != Double.doubleToLongBits(other.open)) {
            return false;
        }
        if (Double.doubleToLongBits(this.close) != Double.doubleToLongBits(other.close)) {
            return false;
        }
        if (Double.doubleToLongBits(this.volume) != Double.doubleToLongBits(other.volume)) {
            return false;
        }
        if (this.date != other.date && (this.date == null || !this.date.equals(other.date))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.low) ^ (Double.doubleToLongBits(this.low) >>> 32));
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.high) ^ (Double.doubleToLongBits(this.high) >>> 32));
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.open) ^ (Double.doubleToLongBits(this.open) >>> 32));
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.close) ^ (Double.doubleToLongBits(this.close) >>> 32));
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.volume) ^ (Double.doubleToLongBits(this.volume) >>> 32));
        hash = 73 * hash + (this.date != null ? this.date.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "QuoteVo{" + "id=" + id + ", low=" + low + ", high=" + high + ", open=" + open + ", close=" + close + ", volume=" + volume + ", date=" + date + ", stock=" + stock + '}';
    }

    

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
    
    
    
}
