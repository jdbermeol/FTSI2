package com.mlg.acciones.dao.dataAccess.implementations;

import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import com.mlg.acciones.dao.dataAccess.DataAccessException;
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
    public void beginTransaction(){
        try{
            getDataAccess().getTransaction().begin();
        }catch(Exception exception){
            throw new DataAccessException(exception.getMessage(), exception);
        }
    }

    @Override
    public void commit() throws DataAccessException {
        try{
            getDataAccess().getTransaction().commit();
        }catch(Exception exception){
            throw new DataAccessException(exception.getMessage(), exception);
        }
    }

    @Override
    public void rollback() throws DataAccessException {
        try{
            getDataAccess().getTransaction().rollback();
        }catch(Exception exception){
            throw new DataAccessException(exception.getMessage(), exception);
        }
    }

    @Override
    public void close() throws DataAccessException {
        try{
            getDataAccess().close();
        }catch(Exception exception){
            throw new DataAccessException(exception.getMessage(), exception);
        }
    }
}
