package com.mlg.acciones.dao.implementations.deleteimplementations;

import com.mlg.acciones.dao.AbstractDaoBuilder;
import com.mlg.acciones.dao.DataBaseException;
import com.mlg.acciones.dao.Delete;
import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import com.mlg.acciones.entity.CompanyEntity;
import com.mlg.acciones.entity.StockEntity;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public class CompanyDeleteBehavior implements Delete<CompanyEntity> {

    private AbstractDaoBuilder daoBuilder;
    private SimpleDeleteBehavior<CompanyEntity> simpleDelete;

    public CompanyDeleteBehavior(AbstractDaoBuilder daoBuilder,
            SimpleDeleteBehavior simpleDelete) {
        this.daoBuilder = daoBuilder;
        this.simpleDelete = simpleDelete;
    }

    @Override
    public void delete(DataAccessAdapter<EntityManager> dataAccessAdapter, CompanyEntity companyEntity) 
            throws DataBaseException {
        deleteStockes(dataAccessAdapter, companyEntity.getId());
        getSimpleDelete().delete(dataAccessAdapter, companyEntity);
    }

    private SimpleDeleteBehavior<CompanyEntity> getSimpleDelete() {
        return simpleDelete;
    }
    
    private void deleteStockes(DataAccessAdapter<EntityManager> dataAccessAdapter, Integer companyId) throws DataBaseException{
        for (StockEntity stockEntity: 
                getDaoBuilder().getStockDao().getByCompanyId(dataAccessAdapter, companyId)){
            getDaoBuilder().getStockDao().delete(dataAccessAdapter, stockEntity.getId());
        }
    }

    private AbstractDaoBuilder getDaoBuilder() {
        return daoBuilder;
    }
}

