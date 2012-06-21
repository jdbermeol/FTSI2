package org.xtremeware.testapp.service;

import org.xtremeware.testapp.da.DataAccessAdapter;
import org.xtremeware.testapp.da.DataAccessException;
import com.mlg.acciones.dao.AbstractDaoFactory;
import com.mlg.acciones.dao.UserDao;
import com.mlg.acciones.vo.UserVo;

public class UserService {

	private static UserService instance = null;

	private UserService() {
	}

	public static UserService getInstance() {
		if (instance == null) {
			instance = new UserService();
		}
		return instance;
	}

	public UserVo create(DataAccessAdapter adapter, UserVo user) throws
		DataAccessException {
		UserDao dao = AbstractDaoFactory.getDaoFactory(adapter).getUserDao();
		return (UserVo) dao.insert(adapter, user);
	}

	public UserVo update(DataAccessAdapter adapter, UserVo user) throws
		DataAccessException {
		UserDao dao = AbstractDaoFactory.getDaoFactory(adapter).getUserDao();
		return (UserVo) dao.update(adapter, user);
	}

	public void remove(DataAccessAdapter adapter, long id) throws
		DataAccessException {
		UserDao dao = AbstractDaoFactory.getDaoFactory(adapter).getUserDao();
		dao.delete(adapter, id);
	}

	public UserVo findById(DataAccessAdapter adapter, long id) throws
		DataAccessException {
		UserDao dao = AbstractDaoFactory.getDaoFactory(adapter).getUserDao();
		return (UserVo) dao.findById(adapter, id);
	}

	public UserVo authenticate(DataAccessAdapter adapter, String userName,
		String password) throws DataAccessException {
		UserDao dao = AbstractDaoFactory.getDaoFactory(adapter).getUserDao();
		return dao.findByUserNameAndPassword(adapter, userName, password);
	}
}
