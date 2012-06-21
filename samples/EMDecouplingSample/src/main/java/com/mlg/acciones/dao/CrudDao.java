package com.mlg.acciones.dao;

import com.mlg.acciones.entity.Entity;
import javax.persistence.EntityManager;

public interface CrudDao<E extends Entity> {

    public void create(EntityManager entityManager, E vo) throws DataBaseException;

    public E update(EntityManager entityManager, E vo) throws DataBaseException;

    public void delete(EntityManager entityManager, long id) throws DataBaseException;

    public E read(EntityManager entityManager, long id) throws DataBaseException;
}
