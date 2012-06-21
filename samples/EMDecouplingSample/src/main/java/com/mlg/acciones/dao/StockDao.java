package com.mlg.acciones.dao;

import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import com.mlg.acciones.entity.StockEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public interface StockDao extends CrudDao<Long, StockEntity> {
    List<StockEntity> getByCompanyId(DataAccessAdapter<EntityManager> dataAccessAdapter, long companyId)
            throws DataBaseException;
}
