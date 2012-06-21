package com.mlg.acciones.facade;

import com.mlg.acciones.dao.dataAccess.AbstractDataAccessFactory;
import com.mlg.acciones.vo.StockVo;
import java.util.List;


/**
 *
 * @author Owner
 */
public class StockFacade {
	private AbstractDataAccessFactory dataSource;

	public StockFacade(AbstractDataAccessFactory dataSource) {
		this.dataSource = dataSource;
	}

    public List<StockVo> getAll(int companyId){
        return null;
    }
    
}
