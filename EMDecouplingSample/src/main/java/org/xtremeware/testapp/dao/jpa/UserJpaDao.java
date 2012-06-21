package org.xtremeware.testapp.dao.jpa;

import javax.persistence.EntityManager;
import org.xtremeware.testapp.da.DataAccessAdapter;
import org.xtremeware.testapp.da.DataAccessException;
import org.xtremeware.testapp.dao.UserDao;
import org.xtremeware.testapp.entity.UserEntity;
import org.xtremeware.testapp.vo.UserVo;

public class UserJpaDao implements UserDao<EntityManager> {

	private static UserJpaDao instance = null;

	private UserJpaDao() {
	}

	public static UserJpaDao getInstance() {
		if (instance == null) {
			instance = new UserJpaDao();
		}
		return instance;
	}

	@Override
	public UserVo insert(DataAccessAdapter<EntityManager> adapter, UserVo vo)
		throws DataAccessException {
		UserEntity entity = voToEntity(vo);
		adapter.getDataAccess().persist(entity);
		return entity.toVo();
	}

	@Override
	public UserVo update(DataAccessAdapter<EntityManager> adapter, UserVo vo)
		throws DataAccessException {
		UserEntity entity = voToEntity(vo);
		adapter.getDataAccess().merge(entity);
		return entity.toVo();
	}

	@Override
	public void delete(DataAccessAdapter<EntityManager> adapter, long id) throws
		DataAccessException {
		adapter.getDataAccess().remove(findEntityById(adapter, id));
	}

	private UserEntity findEntityById(DataAccessAdapter<EntityManager> adapter,
		long id) {
		return adapter.getDataAccess().find(UserEntity.class, id);
	}

	@Override
	public UserVo findById(DataAccessAdapter<EntityManager> adapter, long id)
		throws DataAccessException {
		return findEntityById(adapter, id).toVo();
	}

	@Override
	public UserVo findByUserNameAndPassword(
		DataAccessAdapter<EntityManager> adapter, String userName,
		String password) throws DataAccessException {
		return ((UserEntity) adapter.getDataAccess().createNamedQuery(
			"findUserByUserNameAndPassword").setParameter("userName",
			userName).setParameter("password", password).getSingleResult()).toVo();
	}

	private UserEntity voToEntity(UserVo vo) {
		return new UserEntity(vo.getId(), vo.getUserName(), vo.getPassword());
	}
}
