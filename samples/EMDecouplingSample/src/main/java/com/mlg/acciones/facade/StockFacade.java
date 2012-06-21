/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mlg.acciones.facade;

import com.mlg.acciones.vo.StockVo;
import java.util.List;
import org.xtremeware.testapp.da.DataAccessAdapter;

/**
 *
 * @author Owner
 */
public class StockFacade {
	private DataAccessAdapter dataSource;

	public StockFacade(DataAccessAdapter dataSource) {
		this.dataSource = dataSource;
	}

    public List<StockVo> getAll(int companyId){
        return null;
    }
    
}
