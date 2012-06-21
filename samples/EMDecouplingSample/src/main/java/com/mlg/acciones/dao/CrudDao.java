package com.mlg.acciones.dao;

import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import com.mlg.acciones.entity.Entity;
import javax.persistence.EntityManager;

public interface CrudDao<E, F extends Entity> {
    
    void create(DataAccessAdapter<EntityManager> dataAccessAdapter, F vo) throws DataBaseException;

    F update(DataAccessAdapter<EntityManager> dataAccessAdapter, F vo) throws DataBaseException;

    void delete(DataAccessAdapter<EntityManager> dataAccessAdapter, E id) throws DataBaseException;

    F read(DataAccessAdapter<EntityManager> dataAccessAdapter, E id) throws DataBaseException;
}