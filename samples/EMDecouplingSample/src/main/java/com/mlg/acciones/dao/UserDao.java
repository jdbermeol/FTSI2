package com.mlg.acciones.dao;

import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import com.mlg.acciones.entity.UserEntity;
import javax.persistence.EntityManager;

public interface UserDao extends CrudDao<Long, UserEntity> {

    public UserEntity findByUserNameAndPassword(
            DataAccessAdapter<EntityManager> dataAccessAdapter, String userName, String password)  
            throws DataBaseException;
    
}
