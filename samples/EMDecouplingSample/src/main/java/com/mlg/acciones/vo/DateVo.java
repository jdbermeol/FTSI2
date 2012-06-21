package com.mlg.acciones.vo;

/**
 *
 * @author josebermeo
 */
public class DateVo extends ValueObject{
    
    private Long id;
    private int date;
    private int month;
    private int year;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DateVo other = (DateVo) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.date != other.date) {
            return false;
        }
        if (this.month != other.month) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 61 * hash + this.date;
        hash = 61 * hash + this.month;
        hash = 61 * hash + this.year;
        return hash;
    }

    @Override
    public String toString() {
        return "DateVo{" + "id=" + id + ", date=" + date + ", month=" + month + ", year=" + year + '}';
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    
    
}
