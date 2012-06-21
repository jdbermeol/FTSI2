package com.mlg.acciones.dao;

import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import com.mlg.acciones.entity.CompanyEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public interface CompanyDao extends CrudDao<Integer, CompanyEntity> {
    List<CompanyEntity> getAll(DataAccessAdapter<EntityManager> dataAccessAdapter)
            throws DataBaseException;
    
    List<CompanyEntity> getByMarketId(DataAccessAdapter<EntityManager> dataAccessAdapter, int marketId)
            throws DataBaseException;
}
