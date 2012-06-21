package com.mlg.acciones.facade;

import com.mlg.acciones.dao.dataAccess.AbstractDataAccessFactory;
import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import com.mlg.acciones.dao.dataAccess.implementations.DataAccessFactoryImplementation;
import com.mlg.acciones.vo.CompanyVo;
import java.util.List;

/**
 *
 * @author Owner
 */
public class CompanyFacade {

    private AbstractDataAccessFactory dataSource;

    public CompanyFacade(AbstractDataAccessFactory dataSource) {
        this.dataSource = dataSource;
    }

    public List<CompanyVo> getAll(int marketId) {
        return null;
    }

    public CompanyVo getCompany(int companyId) {
        return null;
    }

    public void createCompany(CompanyVo newCompany) {
    }

    public void updateCompany(CompanyVo newCompany) {
    }

    public void deleteCompany(int companyId) {
    }
}
