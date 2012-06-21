package com.mlg.acciones.service;

import com.mlg.acciones.dao.AbstractDaoBuilder;
import com.mlg.acciones.dao.DataBaseException;
import com.mlg.acciones.dao.CompanyDao;
import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import com.mlg.acciones.entity.CompanyEntity;
import com.mlg.acciones.vo.CompanyVo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public class CompanyService {

    private CompanyDao companyDao;
    private AbstractDaoBuilder abstractDaoBuilder;

    public CompanyService(AbstractDaoBuilder abstractDaoBuilder) {
        this.abstractDaoBuilder = abstractDaoBuilder;
        this.companyDao = abstractDaoBuilder.getCompanyDao();
    }

    public CompanyVo create(DataAccessAdapter<EntityManager> dataAccessAdapter,
            CompanyVo companyVo) throws
            DataBaseException, DataException {
        validateVoForCreation(dataAccessAdapter, companyVo);
        CompanyEntity marketEntity = voToEntity(dataAccessAdapter, companyVo);
        companyDao.create(dataAccessAdapter, marketEntity);
        return marketEntity.toVo();


    }

    private void validateVoForCreation(DataAccessAdapter<EntityManager> dataAccessAdapter,
            CompanyVo companyVo) throws DataException, DataBaseException {
        validateContent(dataAccessAdapter, companyVo);
        if(companyVo.getId() != null){
            throw new DataException("companyVo.id.notNull");
        }
    }

    private void validateContent(DataAccessAdapter<EntityManager> dataAccessAdapter,
            CompanyVo companyVo) throws DataException, DataBaseException {
        if (companyVo == null) {
            throw new DataException("companyVo.null");
        }
        if (companyVo.getDescription() == null) {
            throw new DataException("companyVo.description.null");
        }
        companyVo.setDescription(SecurityHelper.sanitizeHTML(companyVo.getDescription()));
        if (companyVo.getName() == null) {
            throw new DataException("companyVo.name.null");
        }
        companyVo.setName(SecurityHelper.sanitizeHTML(companyVo.getName()));
        if (companyVo.getSymbol() == null) {
            throw new DataException("companyVo.symbol.null");
        }
        companyVo.setSymbol(SecurityHelper.sanitizeHTML(companyVo.getSymbol()));
        if (companyVo.getMarket() == null) {
            throw new DataException("companyVo.market.null");
        } else if (abstractDaoBuilder.getMarketDao().read(dataAccessAdapter, companyVo.getMarket()) == null) {
            throw new DataException("companyVo.market.notElementFound");
        }
    }

    public CompanyVo read(DataAccessAdapter<EntityManager> dataAccessAdapter,
            int valueObjectid) throws DataBaseException {
        CompanyEntity companyEntity = companyDao.read(dataAccessAdapter, valueObjectid);
        if (companyEntity == null) {
            return null;
        } else {
            return companyEntity.toVo();
        }
    }

    public void delete(DataAccessAdapter<EntityManager> dataAccessAdapter,
            int valueObjectid)
            throws DataBaseException {
        companyDao.delete(dataAccessAdapter, valueObjectid);
    }

    public CompanyVo update(DataAccessAdapter<EntityManager> dataAccessAdapter,
            CompanyVo companyVo)
            throws DataBaseException, DataException {
        validateVoForUpdate(dataAccessAdapter, companyVo);
        CompanyEntity companyEntity = companyDao.update(dataAccessAdapter, voToEntity(dataAccessAdapter, companyVo));
        if (companyEntity != null) {
            return companyEntity.toVo();
        } else {
            return null;
        }
    }

    private void validateVoForUpdate(DataAccessAdapter<EntityManager> dataAccessAdapter,
            CompanyVo companyVo) throws DataException, DataBaseException {
        validateContent(dataAccessAdapter, companyVo);
        if(companyVo.getId() == null){
            throw new DataException("companyVo.id.null");
        } else if(companyDao.read(dataAccessAdapter, companyVo.getId()) == null) {
            throw new DataException("companyVo.notElementFound");
        }
    }

    public List<CompanyVo> getAll(DataAccessAdapter<EntityManager> dataAccessAdapter)
            throws DataBaseException {
        List<CompanyVo> results = new ArrayList<CompanyVo>();
        for (CompanyEntity companyEntity : companyDao.getAll(dataAccessAdapter)) {
            results.add(companyEntity.toVo());
        }
        return results;
    }

    public List<CompanyVo> getByMarketId(DataAccessAdapter<EntityManager> dataAccessAdapter,
            int marketId)
            throws DataBaseException {
        List<CompanyVo> results = new ArrayList<CompanyVo>();
        for (CompanyEntity companyEntity : companyDao.getByMarketId(dataAccessAdapter, marketId)) {
            results.add(companyEntity.toVo());
        }
        return results;
    }

    private CompanyEntity voToEntity(DataAccessAdapter<EntityManager> dataAccessAdapter,
            CompanyVo companyVo) throws DataBaseException {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setId(companyVo.getId());
        companyEntity.setName(companyVo.getName());
        companyEntity.setSymbol(companyVo.getSymbol());
        companyEntity.setDescription(companyVo.getDescription());
        companyEntity.setMarket(
                abstractDaoBuilder.getMarketDao().read(dataAccessAdapter, companyVo.getMarket()));
        return companyEntity;
    }
}
