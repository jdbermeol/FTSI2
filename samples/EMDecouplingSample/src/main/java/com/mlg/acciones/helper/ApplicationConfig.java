
package com.mlg.acciones.helper;

import com.mlg.acciones.facade.FacadeFactory;
import com.mlg.acciones.facade.FacadeFactoryInterface;
import javax.persistence.EntityManager;
import org.xtremeware.testapp.da.DataAccessAdapter;

public class ApplicationConfig {
	private static ApplicationConfig instance;
	private FacadeFactoryInterface facadeFactory;

	private ApplicationConfig(DataAccessAdapter generalSource, DataAccessAdapter authSource){
		this.facadeFactory = new FacadeFactory(generalSource, authSource);
	}
	public static synchronized ApplicationConfig getInstance(){
		if(instance == null){
			//TODO : Config sources according to DAA and persistenceUnits available
			DataAccessAdapter<EntityManager> generalSource;
			DataAccessAdapter<EntityManager> authSource;
			instance = new ApplicationConfig(generalSource,authSource);
		}
		return instance;
	}



	public FacadeFactoryInterface getFacadeFactory(){
		return facadeFactory;
	}
	

}
