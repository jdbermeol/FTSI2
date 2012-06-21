package com.mlg.acciones.dao.implementations;

import com.mlg.acciones.dao.CompanyDao;
import com.mlg.acciones.dao.DataBaseException;
import com.mlg.acciones.dao.Delete;
import com.mlg.acciones.entity.CompanyEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public class CompanyDaoImplementation extends CrudDaoImplementation<CompanyEntity>
    implements CompanyDao{

    public CompanyDaoImplementation(Delete delete) {
        super(delete);
    }

    @Override
    protected Class getEntityClass() {
        return CompanyEntity.class;
    }

    @Override
    public List<CompanyEntity> getAll(EntityManager entityManager) throws DataBaseException {
        checkEntityManager(entityManager);
        try {
            return entityManager.createNamedQuery("getAllCompanies",CompanyEntity.class).getResultList();
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<CompanyEntity> getByMarketId(EntityManager entityManager, int marketId) throws DataBaseException {
        checkEntityManager(entityManager);
        try {
            return entityManager.createNamedQuery("getCompaniesByMarketId",CompanyEntity.class)
                    .setParameter("marketId", marketId)
                    .getResultList();
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage(), e.getCause());
        }
    }
    
}
