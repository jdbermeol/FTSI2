package com.mlg.acciones.dao.dataAccess;

public abstract class DataAccessAdapter<E> {

    private E dataAccess;

    public DataAccessAdapter(E dataAccess) {
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

    public abstract void beginTransaction();

    public abstract void commit();

    public abstract void rollback();

    public abstract void close();

}
