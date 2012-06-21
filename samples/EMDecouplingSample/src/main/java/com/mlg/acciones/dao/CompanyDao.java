package com.mlg.acciones.dao;

import com.mlg.acciones.entity.CompanyEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public interface CompanyDao extends CrudDao<CompanyEntity> {
    List<CompanyEntity> getAll(EntityManager entityManager)
            throws DataBaseException;
    
    List<CompanyEntity> getByMarketId(EntityManager entityManager, int marketId)
            throws DataBaseException;
}
