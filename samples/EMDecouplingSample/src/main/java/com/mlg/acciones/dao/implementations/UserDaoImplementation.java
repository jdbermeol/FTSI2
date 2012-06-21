package com.mlg.acciones.dao.implementations;

import com.mlg.acciones.dao.DataBaseException;
import com.mlg.acciones.dao.Delete;
import com.mlg.acciones.dao.UserDao;
import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import com.mlg.acciones.entity.UserEntity;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author josebermeo
 */
public class UserDaoImplementation extends CrudDaoImplementation<Long, UserEntity>
    implements UserDao{

    public UserDaoImplementation(Delete delete) {
        super(delete);
    }
    
    @Override
    protected Class getEntityClass() {
        return UserEntity.class;
    }

    @Override
    public UserEntity findByUserNameAndPassword(DataAccessAdapter<EntityManager> dataAccessAdapter
            , String userName, String password) throws DataBaseException {
        checkEntityManager(dataAccessAdapter);
        try {
            return dataAccessAdapter.getDataAccess()
                    .createNamedQuery("getUserByUserNameAndPassword",
                    UserEntity.class).setParameter("userName", userName).setParameter("password", password).getSingleResult();
        } catch (NoResultException exception) {
            return null;
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage(), e.getCause());
        }
    }
    
}
