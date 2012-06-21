package com.mlg.acciones.dao.dataAccess;

import com.mlg.acciones.dao.DataBaseException;

public interface AbstractDataAccessFactory {

    public DataAccessAdapter createDataAccess() throws DataBaseException;
}