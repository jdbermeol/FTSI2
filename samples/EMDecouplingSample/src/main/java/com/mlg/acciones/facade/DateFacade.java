
package com.mlg.acciones.facade;

import com.mlg.acciones.vo.DateVo;
import org.xtremeware.testapp.da.DataAccessAdapter;

public class DateFacade {
	DataAccessAdapter dataSource;

	public DateFacade(DataAccessAdapter dataSource) {
		this.dataSource = dataSource;
	}

	public DateVo getOrCreateDate(int date,int month,int year){
		return null;
	}

	public DateVo getDate(int dateId){
		return null;
	}

}
