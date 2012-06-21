package com.mlg.acciones.dao;

import com.mlg.acciones.entity.QuoteEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public interface QuoteDao extends CrudDao<QuoteEntity> {
    List<QuoteEntity> getQuoteByAccionId(EntityManager entityManager,long accionId)
            throws DataBaseException;
    
}
