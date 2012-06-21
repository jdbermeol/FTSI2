package com.mlg.acciones.dao.dataAccess.implementations;

import com.mlg.acciones.dao.DataBaseException;
import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public class DataAccesAdapterImplementation extends DataAccessAdapter<EntityManager> {

    public DataAccesAdapterImplementation(EntityManager dataAccess) {
        super(dataAccess);
    }

    @Override
    protected void checkDataAccessClass(EntityManager dataAccess) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void beginTransaction() throws DataBaseException {
       getDataAccess().getTransaction().begin();
    }

    @Override
    public void commit() throws DataBaseException {
        getDataAccess().getTransaction().commit();
    }

    @Override
    public void rollback() throws DataBaseException {
        getDataAccess().getTransaction().rollback();
    }

    @Override
    public void close() throws DataBaseException {
        getDataAccess().close();
    }

    @Override
    public DaoFactoryTypes getType() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
