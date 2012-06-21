package com.mlg.acciones.dao.implementations;

import com.mlg.acciones.dao.*;
import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import com.mlg.acciones.entity.Entity;
import javax.persistence.EntityManager;

public abstract class CrudDaoImplementation<E, F extends Entity>
        implements CrudDao<E, F> {

    private Delete delete;

    public CrudDaoImplementation(Delete delete) {
        this.delete = delete;
    }

    @Override
    public void create(DataAccessAdapter<EntityManager> dataAccessAdapter, F entity)
            throws DataBaseException {
        checkEntityManager(dataAccessAdapter);
        try {
            dataAccessAdapter.getDataAccess().persist(entity);
        } catch (Exception ex) {
            throw new DataBaseException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public F update(DataAccessAdapter<EntityManager> dataAccessAdapter, F entity)
            throws DataBaseException {
        checkEntityManager(dataAccessAdapter);
        try {
            return dataAccessAdapter.getDataAccess().merge(entity);
        } catch (Exception ex) {
            throw new DataBaseException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public void delete(DataAccessAdapter<EntityManager> dataAccessAdapter, E entityId)
            throws DataBaseException {

        checkEntityManager(dataAccessAdapter);

        F entity = read(dataAccessAdapter, entityId);
        if (entity == null) {
            throw new DataBaseException("entity.notFound");
        }
        try {
            getDelete().delete(dataAccessAdapter, entity);
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public F read(DataAccessAdapter<EntityManager> dataAccessAdapter, E entityId)
            throws DataBaseException {
        checkEntityManager(dataAccessAdapter);
        try {
            return (F) dataAccessAdapter.getDataAccess().find(getEntityClass(), entityId);
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage(), e.getCause());
        }


    }

    private Delete getDelete() {
        return delete;
    }

    protected void checkEntityManager(DataAccessAdapter<EntityManager> dataAccessAdapter) 
            throws DataBaseException {
        if (dataAccessAdapter == null) {
            throw new DataBaseException("dataAccessAdapter.null");
        }
        if (dataAccessAdapter.getDataAccess() == null) {
            throw new DataBaseException("dataAccessAdapter.dataAccess.null");
        }
    }

    protected abstract Class getEntityClass();
}
