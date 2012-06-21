/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mlg.acciones.facade;

import com.mlg.acciones.vo.CompanyVo;
import java.util.List;
import org.xtremeware.testapp.da.DataAccessAdapter;

/**
 *
 * @author Owner
 */
public class CompanyFacade {
	private DataAccessAdapter dataSource;

	public CompanyFacade(DataAccessAdapter dataSource) {
		this.dataSource = dataSource;
	}


    public List<CompanyVo> getAll(int marketId){
        return null;
    }
    public CompanyVo getCompany(int companyId){
        return null;
    }
    public void createCompany(CompanyVo newCompany){
        
    }
    public void updateCompany(CompanyVo newCompany){
        
    }
    public void deleteCompany(int companyId){
        
    }
}
