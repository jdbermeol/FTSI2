package com.mlg.acciones.service;

import com.mlg.acciones.dao.DataBaseException;
import com.mlg.acciones.dao.MarketDao;
import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import com.mlg.acciones.entity.MarketEntity;
import com.mlg.acciones.vo.MarketVo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public class MarketService {
    
    private MarketDao marketDao;

    public MarketService(MarketDao marketDao) {
        this.marketDao = marketDao;
    }

    public MarketVo create(DataAccessAdapter<EntityManager> dataAccessAdapter, MarketVo marketVo) throws
            DataBaseException, DataException{
            validateVoForCreation(dataAccessAdapter, marketVo);
            MarketEntity marketEntity = voToEntity(marketVo);
            marketDao.create(dataAccessAdapter, marketEntity);
            return marketEntity.toVo();
    }
    
    private void validateVoForCreation(DataAccessAdapter<EntityManager> dataAccessAdapter, 
            MarketVo marketVo) throws DataException, DataBaseException {
        validateContent(dataAccessAdapter, marketVo);
        if(marketVo.getId() != null){
            throw new DataException("marketVo.id.notNull");
        }
    }

    private void validateContent(DataAccessAdapter<EntityManager> dataAccessAdapter,
            MarketVo marketVo) throws DataException, DataBaseException {
        if (marketVo == null) {
            throw new DataException("companyVo.null");
        }
        if (marketVo.getDescription() == null) {
            throw new DataException("marketVo.description.null");
        }
        marketVo.setDescription(SecurityHelper.sanitizeHTML(marketVo.getDescription()));
        if (marketVo.getName() == null) {
            throw new DataException("companyVo.name.null");
        }
        marketVo.setName(SecurityHelper.sanitizeHTML(marketVo.getName()));
        if (marketVo.getNemo() == null) {
            throw new DataException("marketVo.nemo.null");
        }
        marketVo.setNemo(SecurityHelper.sanitizeHTML(marketVo.getNemo()));
    }
    
    public MarketVo read(DataAccessAdapter<EntityManager> dataAccessAdapter, int valueObjectid) throws DataBaseException {
        MarketEntity marketEntity = marketDao.read(dataAccessAdapter, valueObjectid);
        if (marketEntity == null) {
            return null;
        } else {
            return marketEntity.toVo();
        }
    }
    
    public void delete(DataAccessAdapter<EntityManager> dataAccessAdapter, int valueObjectid)
            throws DataBaseException {
            marketDao.delete(dataAccessAdapter, valueObjectid);
    }
    
    public MarketVo update(DataAccessAdapter<EntityManager> dataAccessAdapter, MarketVo marketVo)
            throws DataBaseException, DataException {
        validateVoForUpdate(dataAccessAdapter, marketVo);
        MarketEntity marketEntity = marketDao.update(dataAccessAdapter, voToEntity(marketVo));
        if (marketEntity != null) {
            return marketEntity.toVo();
        } else {
            return null;
        }

    }
    
     private void validateVoForUpdate(DataAccessAdapter<EntityManager> dataAccessAdapter,
            MarketVo marketVo) throws DataException, DataBaseException {
        validateContent(dataAccessAdapter, marketVo);
        if(marketVo.getId() == null){
            throw new DataException("marketVo.id.null");
        } else if(marketDao.read(dataAccessAdapter, marketVo.getId()) == null) {
            throw new DataException("marketVo.notElementFound");
        }
    }
    
    public List<MarketVo> getAll(DataAccessAdapter<EntityManager> dataAccessAdapter) 
            throws DataBaseException{
        List<MarketVo> results  = new ArrayList<MarketVo>();
        for(MarketEntity marketEntity: marketDao.getAll(dataAccessAdapter)){
            results.add(marketEntity.toVo());
        }
        return results;
    }

    private MarketEntity voToEntity(MarketVo marketVo)  {
        MarketEntity marketEntity = new MarketEntity();
        marketEntity.setId(marketVo.getId());
        marketEntity.setName(marketVo.getName());
        marketEntity.setDescription(marketVo.getDescription());
        marketEntity.setNemo(marketVo.getNemo());
        return marketEntity;
    }
    
}
