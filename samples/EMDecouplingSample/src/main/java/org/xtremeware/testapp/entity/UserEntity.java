package org.xtremeware.testapp.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.xtremeware.testapp.vo.UserVo;

@javax.persistence.Entity(name = "User")
@Table(name = "usertest")
@NamedQueries(
{
    @NamedQuery(name = "findUserByUserNameAndPassword", query =
    "SELECT u FROM User u WHERE u.userName = :userName AND u.password = :password")})
public class UserEntity implements Entity<UserVo> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;

    public UserEntity() {
    }

    public UserEntity(Long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
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

    public UserVo toVo() {
        return new UserVo(getId(), getUserName(), getPassword());
    }
}
