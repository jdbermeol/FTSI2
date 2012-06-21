package com.mlg.acciones.service;

import com.mlg.acciones.dao.*;
import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import com.mlg.acciones.entity.UserEntity;
import com.mlg.acciones.vo.UserVo;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public class UserService {
    
    
    private UserDao userDao;
    private AbstractDaoBuilder abstractDaoBuilder;

    public UserService(AbstractDaoBuilder abstractDaoBuilder) {
        this.abstractDaoBuilder = abstractDaoBuilder;
        this.userDao = abstractDaoBuilder.getUserDao();
    }

    public UserVo create(DataAccessAdapter<EntityManager> dataAccessAdapter,
            UserVo userVo) throws
            DataBaseException, DataException {
        validateVoForCreation(dataAccessAdapter, userVo);
        UserEntity stockEntity = voToEntity(userVo);
        userDao.create(dataAccessAdapter, stockEntity);
        return stockEntity.toVo();
    }
    
    private void validateVoForCreation(DataAccessAdapter<EntityManager> dataAccessAdapter,
            UserVo userVo) throws DataException, DataBaseException {
        validateContent(dataAccessAdapter, userVo);
        if (userVo.getId() != null) {
            throw new DataException("userVo.id.notNull");
        }
    }

    private void validateContent(DataAccessAdapter<EntityManager> dataAccessAdapter,
            UserVo userVo) throws DataException, DataBaseException {
        if (userVo == null) {
            throw new DataException("userVo.null");
        }
        if (userVo.getPassword() == null) {
            throw new DataException("userVo.password.null");
        }
        userVo.setPassword(SecurityHelper.sanitizeHTML(userVo.getPassword()));
        if (userVo.getUserName() == null) {
            throw new DataException("userVo.userName.null");
        }
        userVo.setUserName(SecurityHelper.sanitizeHTML(userVo.getUserName()));
    }

    public UserVo read(DataAccessAdapter<EntityManager> dataAccessAdapter,
            long valueObjectid) throws DataBaseException {
        UserEntity userEntity = userDao.read(dataAccessAdapter, valueObjectid);
        if (userEntity == null) {
            return null;
        } else {
            return userEntity.toVo();
        }
    }

    public void delete(DataAccessAdapter<EntityManager> dataAccessAdapter,
            long valueObjectid)
            throws DataBaseException {
        userDao.delete(dataAccessAdapter, valueObjectid);
    }

    public UserVo update(DataAccessAdapter<EntityManager> dataAccessAdapter,
            UserVo userVo)
            throws DataBaseException, DataException {
        validateVoForUpdate(dataAccessAdapter, userVo);
        UserEntity userEntity = userDao.update(dataAccessAdapter, voToEntity(userVo));
        if (userEntity != null) {
            return userEntity.toVo();
        } else {
            return null;
        }
    }
    
    private void validateVoForUpdate(DataAccessAdapter<EntityManager> dataAccessAdapter,
            UserVo userVo) throws DataException, DataBaseException {
        validateContent(dataAccessAdapter, userVo);
        if(userVo.getId() == null){
            throw new DataException("stockVo.id.null");
        } else if(userDao.read(dataAccessAdapter, userVo.getId()) == null) {
            throw new DataException("stockVo.notElementFound");
        }
    }
    
    public UserVo getByUserNameAndPassword(DataAccessAdapter<EntityManager> dataAccessAdapter,
            String usserName,
            String Password) 
            throws DataBaseException{
        return userDao.findByUserNameAndPassword(dataAccessAdapter, usserName, Password).toVo();
    }

    private UserEntity voToEntity(UserVo userVo) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userVo.getId());
        userEntity.setPassword(userVo.getPassword());
        userEntity.setUserName(userVo.getUserName());
        return userEntity;
    }
}
