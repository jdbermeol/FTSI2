package org.xtremeware.testapp.facade;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.mlg.acciones.dao.AbstractDaoFactory;
import org.xtremeware.testapp.da.AbstractDataAccessFactory;
import org.xtremeware.testapp.da.DataAccessAdapter;
import org.xtremeware.testapp.da.DataAccessException;
import org.xtremeware.testapp.service.ServiceFactory;
import com.mlg.acciones.vo.UserVo;

public class UserFacade {

    AbstractDataAccessFactory dataAccessAdapterFactory;
    ServiceFactory serviceBuilder;

    public UserFacade(AbstractDataAccessFactory dataAccessAdapterFactory,
            ServiceFactory serviceBuilder) {
        this.dataAccessAdapterFactory = dataAccessAdapterFactory;
        this.serviceBuilder = serviceBuilder;
    }

    public UserVo createUser(UserVo user) {
        DataAccessAdapter adapter = null;
        try {
            adapter = dataAccessAdapterFactory.createDataAccess();
            adapter.beginTransaction();
            user = serviceBuilder.getUserService().create(adapter, user);
            adapter.commit();
            return user;
        } catch (DataAccessException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null,
                    ex);
            if (adapter != null) {
                try {
                    adapter.rollback();
                } catch (DataAccessException ex1) {
                    Logger.getLogger(UserFacade.class.getName()).
                            log(Level.SEVERE, null, ex1);
                }
            }
            // TODO: transform this data access exception into a suitable exception for the presentation layer
            return null;
        } finally {
            if (adapter != null) {
                try {
                    adapter.close();
                } catch (Exception ex) {
                    Logger.getLogger(UserFacade.class.getName()).log(
                            Level.SEVERE, null, ex);
                }
            }
        }
    }

    public UserVo updateUser(UserVo user) {
        DataAccessAdapter adapter = null;
        try {
            adapter = dataAccessAdapterFactory.createDataAccess();
            adapter.beginTransaction();
            user = serviceBuilder.getUserService().update(adapter, user);
            adapter.commit();
            return user;
        } catch (DataAccessException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null,
                    ex);
            if (adapter != null) {
                try {
                    adapter.rollback();
                } catch (DataAccessException ex1) {
                    Logger.getLogger(UserFacade.class.getName()).
                            log(Level.SEVERE, null, ex1);
                }
            }
            // TODO: transform this data access exception into a suitable exception for the presentation layer
            return null;
        } finally {
            if (adapter != null) {
                try {
                    adapter.close();
                } catch (Exception ex) {
                    Logger.getLogger(UserFacade.class.getName()).log(
                            Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void removeUser(long id) {
        DataAccessAdapter adapter = null;
        try {
            adapter = dataAccessAdapterFactory.createDataAccess();
            adapter.beginTransaction();
            serviceBuilder.getUserService().remove(adapter, id);
            adapter.commit();
        } catch (DataAccessException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null,
                    ex);
            if (adapter != null) {
                try {
                    adapter.rollback();
                } catch (DataAccessException ex1) {
                    Logger.getLogger(UserFacade.class.getName()).
                            log(Level.SEVERE, null, ex1);
                }
            }
            // TODO: transform this data access exception into a suitable exception for the presentation layer
        } finally {
            if (adapter != null) {
                try {
                    adapter.close();
                } catch (Exception ex) {
                    Logger.getLogger(UserFacade.class.getName()).log(
                            Level.SEVERE, null, ex);
                }
            }
        }
    }

    public UserVo findUserById(long id) {
        DataAccessAdapter adapter = null;
        try {
            adapter = dataAccessAdapterFactory.createDataAccess();
            return serviceBuilder.getUserService().findById(adapter, id);
        } catch (DataAccessException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null,
                    ex);
            // TODO: transform this data access exception into a suitable exception for the presentation layer
            return null;
        } finally {
            if (adapter != null) {
                try {
                    adapter.close();
                } catch (Exception ex) {
                    Logger.getLogger(UserFacade.class.getName()).log(
                            Level.SEVERE, null, ex);
                }
            }
        }
    }

    public UserVo authenticateUser(String userName, String password) {
        DataAccessAdapter adapter = null;
        try {
            adapter = dataAccessAdapterFactory.createDataAccess();
            return serviceBuilder.getUserService().authenticate(adapter,
                    userName, password);
        } catch (DataAccessException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null,
                    ex);
            // TODO: transform this data access exception into a suitable exception for the presentation layer
            return null;
        } finally {
            if (adapter != null) {
                try {
                    adapter.close();
                } catch (Exception ex) {
                    Logger.getLogger(UserFacade.class.getName()).log(
                            Level.SEVERE, null, ex);
                }
            }
        }
    }
}
