package org.xtremeware.testapp.da;

public interface AbstractDataAccessFactory {

    public DataAccessAdapter createDataAccess() throws DataAccessException;
}
