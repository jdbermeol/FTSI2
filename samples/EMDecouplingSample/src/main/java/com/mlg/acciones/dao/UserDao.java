package com.mlg.acciones.dao;

import com.mlg.acciones.entity.UserEntity;
import javax.persistence.EntityManager;

public interface UserDao extends CrudDao<UserEntity> {

    public UserEntity findByUserNameAndPassword(EntityManager entityManager, String userName, String password)  
            throws DataBaseException;
    
}
