package com.mlg.acciones.dao.implementations.deleteimplementations;

import com.mlg.acciones.dao.AbstractDaoBuilder;
import com.mlg.acciones.dao.DataBaseException;
import com.mlg.acciones.dao.Delete;
import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import com.mlg.acciones.entity.QuoteEntity;
import com.mlg.acciones.entity.StockEntity;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public class StockDeleteBehavior implements Delete<StockEntity> {

    private AbstractDaoBuilder daoBuilder;
    private SimpleDeleteBehavior<StockEntity> simpleDelete;

    public StockDeleteBehavior(AbstractDaoBuilder daoBuilder,
            SimpleDeleteBehavior simpleDelete) {
        this.daoBuilder = daoBuilder;
        this.simpleDelete = simpleDelete;
    }

    @Override
    public void delete(DataAccessAdapter<EntityManager> dataAccessAdapter
            , StockEntity stockEntity) throws DataBaseException {
        deleteQuotes(dataAccessAdapter, stockEntity.getId());
        getSimpleDelete().delete(dataAccessAdapter, stockEntity);
    }

    private SimpleDeleteBehavior<StockEntity> getSimpleDelete() {
        return simpleDelete;
    }
    
    private void deleteQuotes(DataAccessAdapter<EntityManager> dataAccessAdapter, Long stockId) 
            throws DataBaseException{
        for (QuoteEntity quoteEntity: 
                getDaoBuilder().getQuoteDao().getQuoteByStockId(dataAccessAdapter, stockId)){
            getDaoBuilder().getQuoteDao().delete(dataAccessAdapter, quoteEntity.getId());
        }
    }

    private AbstractDaoBuilder getDaoBuilder() {
        return daoBuilder;
    }
}
