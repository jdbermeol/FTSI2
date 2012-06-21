package com.mlg.acciones.dao;

import com.mlg.acciones.entity.StockEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public interface StockDao extends CrudDao<StockEntity> {
    List<StockEntity> getByCompanyId(EntityManager entityManager, long companyId)
            throws DataBaseException;
}
