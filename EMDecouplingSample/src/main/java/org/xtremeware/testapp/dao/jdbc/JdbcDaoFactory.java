package org.xtremeware.testapp.dao.jdbc;

import java.sql.Connection;
import org.xtremeware.testapp.dao.AbstractDaoFactory;
import org.xtremeware.testapp.da.JdbcDataAccess;
import org.xtremeware.testapp.dao.UserDao;

public class JdbcDaoFactory extends AbstractDaoFactory<JdbcDataAccess> {

    private UserJdbcDao userDao;
    private static JdbcDaoFactory instance;

    private JdbcDaoFactory(){}

    public static JdbcDaoFactory getInstance(){
	    if(instance == null){
		    instance = new JdbcDaoFactory();
	    }
	    return instance;
    }

    @Override
    public UserDao getUserDao() {
	    return UserJdbcDao.getInstance();
    }
}
