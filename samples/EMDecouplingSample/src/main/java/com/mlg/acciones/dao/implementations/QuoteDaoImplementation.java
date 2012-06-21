package com.mlg.acciones.dao.implementations;

import com.mlg.acciones.dao.DataBaseException;
import com.mlg.acciones.dao.Delete;
import com.mlg.acciones.dao.QuoteDao;
import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import com.mlg.acciones.entity.QuoteEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public class QuoteDaoImplementation extends CrudDaoImplementation<Long, QuoteEntity>
    implements QuoteDao{

    public QuoteDaoImplementation(Delete delete) {
        super(delete);
    }

    @Override
    protected Class getEntityClass() {
        return QuoteEntity.class;
    }

    @Override
    public List<QuoteEntity> getQuoteByStockId(DataAccessAdapter<EntityManager> dataAccessAdapter
            ,long stockId)
            throws DataBaseException{
        checkEntityManager(dataAccessAdapter);
        try {
            return dataAccessAdapter.getDataAccess()
                    .createNamedQuery("getQuotesByStockId",QuoteEntity.class).setParameter("stockId", stockId).getResultList();
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage(), e.getCause());
        }
    }
    
}
