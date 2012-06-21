package org.xtremeware.testapp.da;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xtremeware.testapp.dao.AbstractDaoFactory;
import org.xtremeware.testapp.dao.AbstractDaoFactory.DaoFactoryTypes;

public class JdbcDataAccess extends DataAccessAdapter<Connection> {

	public JdbcDataAccess(Connection dataAccess) {
		super(dataAccess);
	}

	@Override
	protected void checkDataAccessClass(Connection dataAccess) {
		if (dataAccess != null && !(dataAccess instanceof Connection)) {
			throw new IllegalArgumentException("The data access argument must be an instance of java.sql.Connection");
		}
	}

	@Override
	public void beginTransaction() throws DataAccessException {
		checkDataAccessNotNull();
		try {
			dataAccess.setAutoCommit(false);
		} catch (SQLException ex) {
			throw new DataAccessException(ex.getMessage());
		}
	}

	@Override
	public void commit() throws DataAccessException {
		checkDataAccessNotNull();
		try {
			dataAccess.commit();
		} catch (SQLException ex) {
			throw new DataAccessException(ex.getMessage());
		}
	}

	@Override
	public void rollback() throws DataAccessException {
		checkDataAccessNotNull();
		try {
			dataAccess.rollback();
		} catch (SQLException ex) {
			throw new DataAccessException(ex.getMessage());
		}
	}

	@Override
	public void close() throws DataAccessException {
		try {
			dataAccess.close();
		} catch (SQLException ex) {
			throw new DataAccessException(ex.getMessage());
		}
	}

	@Override
	public DaoFactoryTypes getType() {
		return AbstractDaoFactory.DaoFactoryTypes.JDBC;
	}
}
