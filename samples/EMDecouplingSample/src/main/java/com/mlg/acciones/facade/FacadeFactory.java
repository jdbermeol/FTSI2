/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mlg.acciones.facade;

import org.xtremeware.testapp.da.DataAccessAdapter;

/**
 *
 * @author Owner
 */
public class FacadeFactory implements FacadeFactoryInterface{

    private MarketFacade marketFacade;
    private CompanyFacade companyFacade;
    private StockFacade stockFacade;
    private QuoteFacade quoteFacade;
	private DataAccessAdapter generalSource;
	private DataAccessAdapter authenticationSource;
	private DateFacade dateFacade;

	public FacadeFactory(DataAccessAdapter generalSource, DataAccessAdapter authenticationSource) {
		this.generalSource = generalSource;
		this.authenticationSource = authenticationSource;
	}

    public MarketFacade getMarketFacade() {
        if (marketFacade == null) {
            marketFacade = new MarketFacade(generalSource);
        }
        return marketFacade;
    }
    public CompanyFacade getCompanyFacade(){
        if(companyFacade ==null){
            companyFacade = new CompanyFacade(generalSource);
        }
        return companyFacade;
    }
    public StockFacade getStockFacade(){
        if(stockFacade ==null){
            stockFacade = new StockFacade(generalSource);
        }
        return stockFacade;
    }
    
    public QuoteFacade getQuoteFacade(){
        if(quoteFacade ==null){
            quoteFacade = new QuoteFacade(generalSource);
        }
        return quoteFacade;
    }

	public DateFacade getDateFacade(){
		if(dateFacade == null){
			dateFacade = new DateFacade(generalSource);
		}
		return dateFacade;
	}
    
}
