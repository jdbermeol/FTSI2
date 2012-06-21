
package com.mlg.acciones.helper;

import com.mlg.acciones.dao.dataAccess.AbstractDataAccessFactory;
import com.mlg.acciones.dao.dataAccess.implementations.DataAccessFactoryImplementation;
import com.mlg.acciones.facade.FacadeFactory;
import com.mlg.acciones.facade.FacadeFactoryInterface;
import com.mlg.acciones.service.ServiceBuilder;

public class ApplicationConfig {
	private static ApplicationConfig instance;
	private FacadeFactoryInterface facadeFactory;

	private ApplicationConfig(AbstractDataAccessFactory generalSource, AbstractDataAccessFactory authSource){
		this.facadeFactory = new FacadeFactory(generalSource, authSource, new ServiceBuilder());
	}
	public static synchronized ApplicationConfig getInstance(){
		if(instance == null){
			//TODO : Config sources according to DAA and persistenceUnits available
			AbstractDataAccessFactory generalSource = new DataAccessFactoryImplementation("database");
			AbstractDataAccessFactory authSource = new DataAccessFactoryImplementation("authentication");
			instance = new ApplicationConfig(generalSource,authSource);
		}
		return instance;
	}



	public FacadeFactoryInterface getFacadeFactory(){
		return facadeFactory;
	}
	

}
