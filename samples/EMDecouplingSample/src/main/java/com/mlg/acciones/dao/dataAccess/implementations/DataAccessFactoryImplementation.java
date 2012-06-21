package com.mlg.acciones.dao.dataAccess.implementations;

import com.mlg.acciones.dao.dataAccess.AbstractDataAccessFactory;
import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataAccessFactoryImplementation implements AbstractDataAccessFactory {

    //private String persistenceUnit;
    private EntityManagerFactory EMFactory;

    public DataAccessFactoryImplementation(String persistenceUnit) {
        //this.persistenceUnit = persistenceUnit;
        EMFactory = Persistence.createEntityManagerFactory(persistenceUnit);
    }

    @Override
    public DataAccessAdapter createDataAccess() {
        return new DataAccesAdapterImplementation(EMFactory.createEntityManager());
    }
}