/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mlg.acciones.facade;

/**
 *
 * @author Owner
 */
public class FacadeFactory {

    private static FacadeFactory instance;
    private MarketFacade marketFacade;
    private CompanyFacade companyFacade;
    private StockFacade stockFacade;
    private QuoteFacade quoteFacade;

    private FacadeFactory() {
    }

    public static synchronized FacadeFactory getInstance() {
        if (instance == null) {
            instance = new FacadeFactory();
        }
        return instance;
    }

    public MarketFacade getMarketFacade() {
        if (marketFacade == null) {
            marketFacade = new MarketFacade();
        }
        return marketFacade;
    }
    public CompanyFacade getCompanyFacade(){
        if(companyFacade ==null){
            companyFacade = new CompanyFacade();
        }
        return companyFacade;
    }
    public StockFacade getStockFacade(){
        if(stockFacade ==null){
            stockFacade = new StockFacade();
        }
        return stockFacade;
    }
    
    public QuoteFacade getQuoteFacade(){
        if(quoteFacade ==null){
            quoteFacade = new QuoteFacade();
        }
        return quoteFacade;
    }
    
}
