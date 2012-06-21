package com.mlg.acciones.dao.implementations;

import com.mlg.acciones.dao.DataBaseException;
import com.mlg.acciones.dao.Delete;
import com.mlg.acciones.dao.MarketDao;
import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import com.mlg.acciones.entity.MarketEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public class MarketDaoImplementation extends CrudDaoImplementation<Integer, MarketEntity> 
    implements MarketDao{

    public MarketDaoImplementation(Delete delete) {
        super(delete);
    }

    @Override
    protected Class getEntityClass() {
        return MarketEntity.class;
    }

    @Override
    public List<MarketEntity> getAll(DataAccessAdapter<EntityManager> dataAccessAdapter) throws DataBaseException {
        checkEntityManager(dataAccessAdapter);
        try {
            return dataAccessAdapter.getDataAccess()
                    .createNamedQuery("getAllMarkets",MarketEntity.class).getResultList();
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage(), e.getCause());
        }
    }

}
