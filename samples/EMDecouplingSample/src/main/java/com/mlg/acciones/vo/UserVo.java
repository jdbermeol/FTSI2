package com.mlg.acciones.vo;

import java.util.List;

public class UserVo extends ValueObject {

    private Integer id;
    private String userName;
    private String password;
    private List<Integer> rol;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserVo other = (UserVo) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.userName == null) ? (other.userName != null) : !this.userName.equals(other.userName)) {
            return false;
        }
        if ((this.password == null) ? (other.password != null) : !this.password.equals(other.password)) {
            return false;
        }
        if (this.rol != other.rol && (this.rol == null || !this.rol.equals(other.rol))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 13 * hash + (this.userName != null ? this.userName.hashCode() : 0);
        hash = 13 * hash + (this.password != null ? this.password.hashCode() : 0);
        hash = 13 * hash + (this.rol != null ? this.rol.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "UserVo{" + "id=" + id + ", userName=" + userName + ", password=" + password + ", rol=" + rol + '}';
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Integer> getRol() {
        return rol;
    }

    public void setRol(List<Integer> rol) {
        this.rol = rol;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    
}
