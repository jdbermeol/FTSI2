package org.xtremeware.testapp.dao;

import org.xtremeware.testapp.da.DataAccessException;
import org.xtremeware.testapp.da.DataAccessAdapter;
import org.xtremeware.testapp.vo.UserVo;

public interface UserDao<E> extends Dao<E, UserVo> {

    public UserVo findByUserNameAndPassword(DataAccessAdapter<E> adapter, String userName, String password)  throws DataAccessException;
}
