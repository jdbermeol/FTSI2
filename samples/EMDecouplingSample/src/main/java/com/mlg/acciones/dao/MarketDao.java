package com.mlg.acciones.dao;

import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import com.mlg.acciones.entity.MarketEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public interface MarketDao extends CrudDao<Integer, MarketEntity> {
    List<MarketEntity> getAll(DataAccessAdapter<EntityManager> dataAccessAdapter) throws DataBaseException;
}
