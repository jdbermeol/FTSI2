/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mlg.acciones.facade;

import com.mlg.acciones.vo.QuoteVo;
import java.util.List;
import org.xtremeware.testapp.da.DataAccessAdapter;

/**
 *
 * @author Owner
 */
public class QuoteFacade {
	private DataAccessAdapter dataAccess;

	public QuoteFacade(DataAccessAdapter dataAccess) {
		this.dataAccess = dataAccess;
	}

    public List<QuoteVo> getAll(long stockId){
        return null;       
    }
}
