package com.mlg.acciones.dao.implementations;

import com.mlg.acciones.dao.DataBaseException;
import com.mlg.acciones.dao.Delete;
import com.mlg.acciones.dao.StockDao;
import com.mlg.acciones.entity.StockEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public class StockDaoImplementation extends CrudDaoImplementation<StockEntity>
    implements StockDao{

    public StockDaoImplementation(Delete delete) {
        super(delete);
    }

    @Override
    protected Class getEntityClass() {
        return StockEntity.class;
    }

    @Override
    public List<StockEntity> getByCompanyId(EntityManager entityManager, long companyId) throws DataBaseException {
        checkEntityManager(entityManager);
        try {
            return entityManager.createNamedQuery("getStocksByAccionId",StockEntity.class).setParameter("companyId", companyId).getResultList();
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage(), e.getCause());
        }
    }
    
}
