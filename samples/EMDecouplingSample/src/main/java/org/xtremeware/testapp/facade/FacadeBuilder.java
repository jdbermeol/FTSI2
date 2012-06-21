package org.xtremeware.testapp.facade;

import com.mlg.acciones.dao.AbstractDaoFactory;
import org.xtremeware.testapp.da.AbstractDataAccessFactory;
import org.xtremeware.testapp.service.ServiceFactory;

public class FacadeBuilder {

    private AbstractDataAccessFactory dataAccessAdapterFactory;
    private ServiceFactory serviceBuilder;
    private UserFacade userFacade;

	public FacadeBuilder(AbstractDataAccessFactory dataAccessAdapterFactory, ServiceFactory serviceBuilder) {
		this.dataAccessAdapterFactory = dataAccessAdapterFactory;
		this.serviceBuilder = serviceBuilder;
	}

    public UserFacade getUserFacade() {
        if (userFacade == null) {
            userFacade = new UserFacade(dataAccessAdapterFactory, serviceBuilder);
        }
        return userFacade;
    }
}
