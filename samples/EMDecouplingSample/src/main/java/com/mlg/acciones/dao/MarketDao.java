package com.mlg.acciones.dao;

import com.mlg.acciones.entity.MarketEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public interface MarketDao extends CrudDao<MarketEntity> {
    List<MarketEntity> getAll(EntityManager entityManager) throws DataBaseException;
}
