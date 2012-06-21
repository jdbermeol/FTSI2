package com.mlg.acciones.dao.implementations;

import com.mlg.acciones.dao.DataBaseException;
import com.mlg.acciones.dao.Delete;
import com.mlg.acciones.dao.QuoteDao;
import com.mlg.acciones.entity.QuoteEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public class QuoteDaoImplementation extends CrudDaoImplementation<QuoteEntity>
    implements QuoteDao{

    public QuoteDaoImplementation(Delete delete) {
        super(delete);
    }

    @Override
    protected Class getEntityClass() {
        return QuoteEntity.class;
    }

    @Override
    public List<QuoteEntity> getQuoteByAccionId(EntityManager entityManager,long accionId)
            throws DataBaseException{
        checkEntityManager(entityManager);
        try {
            return entityManager.createNamedQuery("getQuotesByAccionId",QuoteEntity.class).setParameter("accionId", accionId).getResultList();
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage(), e.getCause());
        }
    }
    
}
