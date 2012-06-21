package com.mlg.acciones.dao.implementations;

import com.mlg.acciones.dao.CompanyDao;
import com.mlg.acciones.dao.DataBaseException;
import com.mlg.acciones.dao.Delete;
import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import com.mlg.acciones.entity.CompanyEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public class CompanyDaoImplementation extends CrudDaoImplementation<Integer, CompanyEntity>
        implements CompanyDao {

    public CompanyDaoImplementation(Delete delete) {
        super(delete);
    }

    @Override
    protected Class getEntityClass() {
        return CompanyEntity.class;
    }

    @Override
    public List<CompanyEntity> getAll(DataAccessAdapter<EntityManager> dataAccessAdapter) throws DataBaseException {
        checkEntityManager(dataAccessAdapter);
        try {
            return dataAccessAdapter.getDataAccess()
                    .createNamedQuery("getAllCompanies", CompanyEntity.class).getResultList();
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<CompanyEntity> getByMarketId(DataAccessAdapter<EntityManager> dataAccessAdapter, int marketId) throws DataBaseException {
        checkEntityManager(dataAccessAdapter);
        try {
            return dataAccessAdapter.getDataAccess()
                    .createNamedQuery("getCompaniesByMarketId", CompanyEntity.class).setParameter("marketId", marketId).getResultList();
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage(), e.getCause());
        }
    }
}
