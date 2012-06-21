package org.xtremeware.testapp.dao;

import org.xtremeware.testapp.da.DataAccessException;
import org.xtremeware.testapp.da.DataAccessAdapter;
import org.xtremeware.testapp.vo.ValueObject;

public interface Dao<E, F extends ValueObject> {

    public F insert(DataAccessAdapter<E> adapter, F vo) throws DataAccessException;

    public F update(DataAccessAdapter<E> adapter, F vo) throws DataAccessException;

    public void delete(DataAccessAdapter<E> adapter, long id) throws DataAccessException;

    public F findById(DataAccessAdapter<E> adapter, long id) throws DataAccessException;
}
