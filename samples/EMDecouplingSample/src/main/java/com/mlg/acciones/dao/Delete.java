package com.mlg.acciones.dao;

import com.mlg.acciones.entity.Entity;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public interface Delete<E extends Entity> {

    void delete(EntityManager entityManager, E entity)
            throws DataBaseException;
}
