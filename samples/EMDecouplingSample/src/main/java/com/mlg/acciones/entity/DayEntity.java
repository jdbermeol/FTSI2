/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mlg.acciones.entity;

import com.mlg.acciones.vo.DateVo;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author josebermeo
 */

@javax.persistence.Entity(name = "Date")
public class DayEntity implements Entity<DateVo, Long>, Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int date_;
    private int month_;
    private int year_;

    public int getDate() {
        return date_;
    }

    public void setDate(int date) {
        this.date_ = date;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public int getMonth() {
        return month_;
    }

    public void setMonth(int month) {
        this.month_ = month;
    }

    public int getYear() {
        return year_;
    }

    public void setYear(int year) {
        this.year_ = year;
    }

    @Override
    public DateVo toVo() {
        DateVo newVo =  new DateVo();
        newVo.setId(this.getId());
        newVo.setDate(this.getDate());
        newVo.setMonth(this.getMonth());
        newVo.setYear(this.getYear());
        return newVo;
    }

    
    
   
    
}
