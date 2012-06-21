package com.mlg.acciones.dao;

import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import com.mlg.acciones.entity.Entity;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public interface Delete<E extends Entity> {

    void delete(DataAccessAdapter<EntityManager> dataAccessAdapter, E entity)
            throws DataBaseException;
}
