package com.mlg.acciones.dao.dataAccess;

import com.mlg.acciones.dao.DataBaseException;

public abstract class DataAccessAdapter<E> {

    private E dataAccess;

    public DataAccessAdapter(E dataAccess) {
        checkDataAccessClass(dataAccess);
        this.dataAccess = dataAccess;
    }

    public E getDataAccess() {
        return dataAccess;
    }

    protected abstract void checkDataAccessClass(E dataAccess);

    protected void checkDataAccessNotNull() {
        if (dataAccess == null) {
            throw new IllegalStateException("The data access object is null");
        }
    }

    public abstract void beginTransaction() throws DataBaseException;

    public abstract void commit() throws DataBaseException;

    public abstract void rollback() throws DataBaseException;

    public abstract void close() throws DataBaseException;

}
