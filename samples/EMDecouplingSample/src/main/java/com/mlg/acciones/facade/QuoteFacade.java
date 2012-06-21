/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mlg.acciones.facade;

import com.mlg.acciones.dao.dataAccess.AbstractDataAccessFactory;
import com.mlg.acciones.vo.QuoteVo;
import java.util.List;


/**
 *
 * @author Owner
 */
public class QuoteFacade {
	private AbstractDataAccessFactory dataAccess;

	public QuoteFacade(AbstractDataAccessFactory dataAccess) {
		this.dataAccess = dataAccess;
	}

    public List<QuoteVo> getAll(long stockId){
        return null;       
    }
}
