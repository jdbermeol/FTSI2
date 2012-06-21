package com.mlg.acciones.service;

import com.mlg.acciones.dao.AbstractDaoBuilder;
import com.mlg.acciones.dao.DataBaseException;
import com.mlg.acciones.dao.StockDao;
import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import com.mlg.acciones.entity.StockEntity;
import com.mlg.acciones.vo.StockVo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public class StockService {

    private StockDao stockDao;
    private AbstractDaoBuilder abstractDaoBuilder;
    private StockMeassure stockMeassure;

    public void setStockMeassure(StockMeassure stockMeassure) {
        this.stockMeassure = stockMeassure;
    }

    public StockService(AbstractDaoBuilder abstractDaoBuilder) {
        this.abstractDaoBuilder = abstractDaoBuilder;
        this.stockDao = abstractDaoBuilder.getStockDao();
    }

    public StockVo create(DataAccessAdapter<EntityManager> dataAccessAdapter, StockVo stockVo) throws
            DataBaseException, DataException {
        validateVoForCreation(dataAccessAdapter, stockVo);
        StockEntity stockEntity = voToEntity(dataAccessAdapter, stockVo);
        stockDao.create(dataAccessAdapter, stockEntity);
        return stockEntity.toVo();
    }
    
    private void validateVoForCreation(DataAccessAdapter<EntityManager> dataAccessAdapter, 
            StockVo stockVo) throws DataException, DataBaseException {
        validateContent(dataAccessAdapter, stockVo);
        if (stockVo.getId() != null) {
            throw new DataException("stockVos.id.notNull");
        }
    }

    private void validateContent(DataAccessAdapter<EntityManager> dataAccessAdapter, 
            StockVo stockVo) throws DataException, DataBaseException {
        if (stockVo == null) {
            throw new DataException("stockVo.null");
        }
        if (stockVo.getDescription() == null) {
            throw new DataException("stockVos.descripcion.null");
        }
        stockVo.setDescription(SecurityHelper.sanitizeHTML(stockVo.getDescription()));
        if (stockVo.getName() == null) {
            throw new DataException("stockVos.name.null");
        }
        stockVo.setName(SecurityHelper.sanitizeHTML(stockVo.getName()));
        if (stockVo.getSymbol() == null) {
            throw new DataException("stockVos.symbol.null");
        }
        stockVo.setSymbol(SecurityHelper.sanitizeHTML(stockVo.getSymbol()));
        if (stockVo.getCompany() == null) {
            throw new DataException("stockVos.company.null");
        } else if(abstractDaoBuilder.getCompanyDao().read(dataAccessAdapter, stockVo.getCompany()) == null){
            throw new DataException("stockVos.company.notFoundElement");
        }
    }

    public StockVo read(DataAccessAdapter<EntityManager> dataAccessAdapter, long valueObjectid) throws DataBaseException {
        StockEntity stockEntity = stockDao.read(dataAccessAdapter, valueObjectid);
        if (stockEntity == null) {
            return null;
        } else {
            return stockEntity.toVo();
        }
    }

    public void delete(DataAccessAdapter<EntityManager> dataAccessAdapter, long valueObjectid)
            throws DataBaseException {
        stockDao.delete(dataAccessAdapter, valueObjectid);
    }

    public StockVo update(DataAccessAdapter<EntityManager> dataAccessAdapter, StockVo companyVo)
            throws DataBaseException, DataException {
        validateVoForUpdate(dataAccessAdapter, companyVo);
        StockEntity stockEntity = stockDao.update(dataAccessAdapter, voToEntity(dataAccessAdapter, companyVo));
        if (stockEntity != null) {
            return stockEntity.toVo();
        } else {
            return null;
        }
    }
    
    private void validateVoForUpdate(DataAccessAdapter<EntityManager> dataAccessAdapter, 
            StockVo stockVo) throws DataException, DataBaseException {
        validateContent(dataAccessAdapter, stockVo);
        if(stockVo.getId() == null){
            throw new DataException("stockVo.id.null");
        } else if(stockDao.read(dataAccessAdapter, stockVo.getId()) == null) {
            throw new DataException("stockVo.notElementFound");
        }
    }
    
    public List<StockVo> getByCompanyId(DataAccessAdapter<EntityManager> dataAccessAdapter, int companyId) 
            throws DataBaseException{
        List<StockVo> stockList= new ArrayList<StockVo>();
        for(StockEntity stockEntity: 
                stockDao.getByCompanyId(dataAccessAdapter, companyId)){
            stockList.add(stockEntity.toVo());
        }
        return stockList;
    }
    
    public double computeMeassure(DataAccessAdapter<EntityManager> dataAccessAdapter,Long stockId) throws DataBaseException{
        return stockMeassure.getMeassureResult(
                abstractDaoBuilder.getQuoteDao().getQuoteByStockId(null, stockId));
    }

    private StockEntity voToEntity(DataAccessAdapter<EntityManager> dataAccessAdapter, StockVo stockVo) 
            throws DataBaseException {
        StockEntity stockEntity = new StockEntity();
        stockEntity.setId(stockVo.getId());
        stockEntity.setDescription(stockVo.getDescription());
        stockEntity.setName(stockVo.getName());
        stockEntity.setSymbol(stockVo.getSymbol());
        stockEntity.setCompany(abstractDaoBuilder.getCompanyDao().read(
                dataAccessAdapter, stockVo.getCompany()));
        return stockEntity;
    }
}
