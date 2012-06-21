package com.mlg.acciones.dao;

import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import com.mlg.acciones.entity.QuoteEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public interface QuoteDao extends CrudDao<Long, QuoteEntity> {
    List<QuoteEntity> getQuoteByStockId(DataAccessAdapter<EntityManager> dataAccessAdapter,long stockId)
            throws DataBaseException;
    
}
