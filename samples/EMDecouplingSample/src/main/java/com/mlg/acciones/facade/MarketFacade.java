
package com.mlg.acciones.facade;

import com.mlg.acciones.dao.DataBaseException;
import com.mlg.acciones.dao.dataAccess.AbstractDataAccessFactory;
import com.mlg.acciones.service.ServiceBuilder;
import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import com.mlg.acciones.service.DataException;
import com.mlg.acciones.vo.CompanyVo;
import com.mlg.acciones.vo.MarketVo;
import com.mlg.acciones.vo.StockVo;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Owner
 */
public class MarketFacade {

    private ServiceBuilder serviceBuilder;    
    private AbstractDataAccessFactory dataSource;

    public MarketFacade(AbstractDataAccessFactory dataSource,
            ServiceBuilder seviceBuilder) {
        this.dataSource = dataSource;
        this.serviceBuilder = seviceBuilder;
    }

    public List<MarketVo> getAll() {
        DataAccessAdapter dataAccessAdapter = null;
        List<MarketVo> results = new ArrayList<MarketVo>();
        try {
            dataAccessAdapter = dataSource.createDataAccess();
            results = serviceBuilder.getMarketService().getAll(dataAccessAdapter);
        } catch (Exception exception) {
			exception.printStackTrace();
        } finally {
            FacadesHelper.closeEntityManager(dataAccessAdapter);
        }
        return results;
    }

    public void createMarket(MarketVo market, CompanyVo firstCompany, StockVo firstStock) 
            throws DataException, DataBaseException {
        DataAccessAdapter dataAccessAdapter = null;
        try {
            dataAccessAdapter = dataSource.createDataAccess();
            dataAccessAdapter.beginTransaction();
            MarketVo marketVo = serviceBuilder.getMarketService().create(dataAccessAdapter, market);
            firstCompany.setMarket(marketVo.getId());
            CompanyVo companyVo = serviceBuilder.getCompanyService().create(dataAccessAdapter, firstCompany);
            firstStock.setCompany(companyVo.getId());
            StockVo create = serviceBuilder.getStockService().create(dataAccessAdapter, firstStock);
            dataAccessAdapter.commit();
        } catch (Exception exception) {
            FacadesHelper.checkException(dataAccessAdapter, exception, DataException.class);
            FacadesHelper.checkExceptionAndRollback(dataAccessAdapter, exception, DataBaseException.class);
            
        } finally {
            FacadesHelper.closeEntityManager(dataAccessAdapter);
        }
    }
}
