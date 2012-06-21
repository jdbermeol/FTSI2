package com.mlg.acciones.service;

import com.mlg.acciones.dao.AbstractDaoBuilder;
import com.mlg.acciones.dao.DataBaseException;
import com.mlg.acciones.dao.QuoteDao;
import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import com.mlg.acciones.entity.QuoteEntity;
import com.mlg.acciones.vo.QuoteVo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public class QuoteService {

    private QuoteDao quoteDao;
    private AbstractDaoBuilder abstractDaoBuilder;

    public QuoteService(AbstractDaoBuilder abstractDaoBuilder) {
        this.abstractDaoBuilder = abstractDaoBuilder;
        this.quoteDao = abstractDaoBuilder.getQuoteDao();
    }

    public QuoteVo create(DataAccessAdapter<EntityManager> dataAccessAdapter,
            QuoteVo quoteVo) throws
            DataBaseException, DataException {
        validateVoForCreation(dataAccessAdapter, quoteVo);
        QuoteEntity stockEntity = voToEntity(dataAccessAdapter, quoteVo);
        quoteDao.create(dataAccessAdapter, stockEntity);
        return stockEntity.toVo();
    }

    private void validateVoForCreation(DataAccessAdapter<EntityManager> dataAccessAdapter,
            QuoteVo quoteVo) throws DataException, DataBaseException {
        validateContent(dataAccessAdapter, quoteVo);
        if (quoteVo.getId() != null) {
            throw new DataException("quoteVo.id.notNull");
        }
    }

    private void validateContent(DataAccessAdapter<EntityManager> dataAccessAdapter,
            QuoteVo quoteVo) throws DataException, DataBaseException {
        if (quoteVo == null) {
            throw new DataException("quoteVo.null");
        }
        if (quoteVo.getDate() == null) {
            throw new DataException("quoteVo.date.null");
        } else if (abstractDaoBuilder.getDateDao().read(dataAccessAdapter, quoteVo.getDate()) == null) {
            throw new DataException("quoteVo.date.notFoundElement");
        }
        if (quoteVo.getStock() == null) {
            throw new DataException("quoteVo.stock.null");
        } else if (abstractDaoBuilder.getStockDao().read(dataAccessAdapter, quoteVo.getStock()) == null) {
            throw new DataException("quoteVo.stock.notFoundElement");
        }
    }

    public QuoteVo read(DataAccessAdapter<EntityManager> dataAccessAdapter,
            long valueObjectid) throws DataBaseException {
        QuoteEntity quoteEntity = quoteDao.read(dataAccessAdapter, valueObjectid);
        if (quoteEntity == null) {
            return null;
        } else {
            return quoteEntity.toVo();
        }
    }

    public void delete(DataAccessAdapter<EntityManager> dataAccessAdapter,
            long valueObjectid)
            throws DataBaseException {
        quoteDao.delete(dataAccessAdapter, valueObjectid);
    }

    public QuoteVo update(DataAccessAdapter<EntityManager> dataAccessAdapter,
            QuoteVo companyVo)
            throws DataBaseException, DataException {
        validateVoForUpdate(dataAccessAdapter, companyVo);
        QuoteEntity quoteEntity = quoteDao.update(dataAccessAdapter, voToEntity(dataAccessAdapter, companyVo));
        if (quoteEntity != null) {
            return quoteEntity.toVo();
        } else {
            return null;
        }

    }
    
    private void validateVoForUpdate(DataAccessAdapter<EntityManager> dataAccessAdapter,
            QuoteVo quoteVo) throws DataException, DataBaseException {
        validateContent(dataAccessAdapter, quoteVo);
        if(quoteVo.getId() == null){
            throw new DataException("quoteVo.id.null");
        } else if(quoteDao.read(dataAccessAdapter, quoteVo.getId()) == null) {
            throw new DataException("quoteVo.notElementFound");
        }
    }

    public List<QuoteVo> getByStockId(DataAccessAdapter<EntityManager> dataAccessAdapter,
            long stockId)
            throws DataBaseException {
        List<QuoteVo> quoteList = new ArrayList<QuoteVo>();
        for (QuoteEntity stockEntity :
                quoteDao.getQuoteByStockId(dataAccessAdapter, stockId)) {
            quoteList.add(stockEntity.toVo());
        }
        return quoteList;
    }

    private QuoteEntity voToEntity(DataAccessAdapter<EntityManager> dataAccessAdapter,
            QuoteVo quoteVo)
            throws DataBaseException {
        QuoteEntity quoteEntity = new QuoteEntity();
        quoteEntity.setId(quoteVo.getId());
        quoteEntity.setClose(quoteVo.getClose());
        quoteEntity.setHigh(quoteVo.getHigh());
        quoteEntity.setLow(quoteVo.getLow());
        quoteEntity.setOpen(quoteVo.getOpen());
        quoteEntity.setVolume(quoteVo.getVolume());
        quoteEntity.setDate_(
                abstractDaoBuilder.getDateDao().read(dataAccessAdapter, quoteVo.getDate()));
        quoteEntity.setStock(
                abstractDaoBuilder.getStockDao().read(dataAccessAdapter, quoteVo.getStock()));
        return quoteEntity;
    }
}
