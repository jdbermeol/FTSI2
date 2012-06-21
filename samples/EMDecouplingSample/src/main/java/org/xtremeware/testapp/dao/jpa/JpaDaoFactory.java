package org.xtremeware.testapp.dao.jpa;

import javax.persistence.EntityManager;
import com.mlg.acciones.dao.AbstractDaoFactory;
import org.xtremeware.testapp.da.JpaDataAccess;
import com.mlg.acciones.dao.UserDao;

public class JpaDaoFactory extends AbstractDaoFactory<JpaDataAccess> {

    private static JpaDaoFactory instance = null;

    private UserJpaDao userDao;

    private JpaDaoFactory(){}

    public static JpaDaoFactory getInstance(){
	    if(instance == null){
		    instance = new JpaDaoFactory();
	    }
	    return instance;
    }

    @Override
    public UserDao getUserDao() {
	    return UserJpaDao.getInstance();
    }
}
