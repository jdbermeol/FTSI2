package com.mlg.acciones.dao.implementations;

import com.mlg.acciones.dao.DataBaseException;
import com.mlg.acciones.dao.Delete;
import com.mlg.acciones.dao.MarketDao;
import com.mlg.acciones.entity.MarketEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public class MarketDaoImplementation extends CrudDaoImplementation<MarketEntity> 
    implements MarketDao{

    public MarketDaoImplementation(Delete delete) {
        super(delete);
    }

    @Override
    protected Class getEntityClass() {
        return MarketEntity.class;
    }

    @Override
    public List<MarketEntity> getAll(EntityManager entityManager) throws DataBaseException {
        checkEntityManager(entityManager);
        try {
            return entityManager.createNamedQuery("getAllMarkets",MarketEntity.class).getResultList();
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage(), e.getCause());
        }
    }

}
