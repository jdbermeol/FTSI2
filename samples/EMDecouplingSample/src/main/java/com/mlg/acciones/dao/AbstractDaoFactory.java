package com.mlg.acciones.dao;

import org.xtremeware.testapp.da.DataAccessAdapter;
import org.xtremeware.testapp.dao.jdbc.JdbcDaoFactory;
import org.xtremeware.testapp.dao.jpa.JpaDaoFactory;

public abstract class AbstractDaoFactory<E extends DataAccessAdapter> {

	public Class<E> clase ;

	public static enum DaoFactoryTypes {

		JPA, JDBC
	}

	public static AbstractDaoFactory getDaoFactory(DataAccessAdapter da) {
		AbstractDaoFactory daoFactory = null;
		if (da.getType() == DaoFactoryTypes.JDBC) {
			daoFactory = JdbcDaoFactory.getInstance();
		}
		if (da.getType() == DaoFactoryTypes.JPA) {
			daoFactory = JpaDaoFactory.getInstance();
		}
		return daoFactory;
	}

	public abstract UserDao getUserDao();
}
