package com.mlg.acciones.dao.implementations.deleteimplementations;

import com.mlg.acciones.dao.DataBaseException;
import com.mlg.acciones.dao.Delete;
import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import com.mlg.acciones.entity.Entity;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public class SimpleDeleteBehavior<E extends Entity> implements Delete<E>{
    
    @Override
    public void delete(DataAccessAdapter<EntityManager> dataAccessAdapter, E entity) throws DataBaseException {
        try {
            dataAccessAdapter.getDataAccess().remove(entity);
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage(), e.getCause());
        }
    }
}
