package com.mlg.acciones.entity;

import com.mlg.acciones.vo.UserVo;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
@javax.persistence.Entity(name = "User")
@NamedQuery(name = "getUserByUserNameAndPassword",
    query = "SELECT result FROM User result"
        +"WHERE result.userName = :userName AND result.password = :password")
public class UserEntity implements Entity<UserVo>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    

    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserEntity other = (UserEntity) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.userName == null) ? (other.userName != null) : !this.userName.equals(other.userName)) {
            return false;
        }
        if ((this.password == null) ? (other.password != null) : !this.password.equals(other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 17 * hash + (this.userName != null ? this.userName.hashCode() : 0);
        hash = 17 * hash + (this.password != null ? this.password.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "UserVo{" + "id=" + id + ", username=" + userName + ", password=" + password + '}';
    }

    @Override
    public UserVo toVo() {
        UserVo newVo = new UserVo();
        newVo.setId(this.getId());
        newVo.setPassword(this.getPassword());
        newVo.setUserName(this.getUserName());
        return newVo;
    }
}
