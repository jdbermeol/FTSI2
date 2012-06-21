/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mlg.acciones.facade;

import com.mlg.acciones.vo.CompanyVo;
import com.mlg.acciones.vo.MarketVo;
import com.mlg.acciones.vo.StockVo;
import java.util.List;
import org.xtremeware.testapp.da.DataAccessAdapter;

/**
 *
 * @author Owner
 */
public class MarketFacade {
	
	private DataAccessAdapter dataAccessAdapter;

	public MarketFacade(DataAccessAdapter dataAccessAdapter) {
		this.dataAccessAdapter = dataAccessAdapter;
	}

    public List<MarketVo> getAll(){
        return null;
    }
	public void createMarket(MarketVo market,CompanyVo firstCompany,StockVo firstStock){
		
	}
}
