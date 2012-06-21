package com.mlg.acciones.dao.implementations;

import com.mlg.acciones.dao.CrudDao;
import com.mlg.acciones.dao.DataBaseException;
import com.mlg.acciones.dao.Delete;
import com.mlg.acciones.entity.Entity;
import javax.persistence.EntityManager;


public abstract class CrudDaoImplementation<E extends Entity> implements CrudDao<E> {
    
    private Delete delete;

    public CrudDaoImplementation(Delete delete) {
        this.delete = delete;
    }

    @Override
    public void create(EntityManager entityManager, E entity)
            throws DataBaseException {
        checkEntityManager(entityManager);
        try {
            entityManager.persist(entity);
        } catch (Exception ex) {
            throw new DataBaseException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public E update(EntityManager entityManager, E entity)
            throws DataBaseException {
        checkEntityManager(entityManager);
        try {
            return entityManager.merge(entity);
        } catch (Exception ex) {
            throw new DataBaseException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public void delete(EntityManager entityManager, long entityId)
            throws DataBaseException {

        checkEntityManager(entityManager);

        E entity = read(entityManager, entityId);
        if (entity == null) {
            throw new DataBaseException("entity.notFound");
        }
        try {
            getDelete().delete(entityManager, entity);
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public E read(EntityManager entityManager, long entityId)
            throws DataBaseException {
        checkEntityManager(entityManager);
        try {
            return (E) entityManager.find(getEntityClass(), entityId);
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage(), e.getCause());
        }


    }
    
    private Delete getDelete(){
        return delete;
    }

    protected void checkEntityManager(EntityManager entityManager) throws DataBaseException {
        if (entityManager == null) {
            throw new DataBaseException("entityManager.null");
        }
    }

    protected abstract Class getEntityClass();
}
