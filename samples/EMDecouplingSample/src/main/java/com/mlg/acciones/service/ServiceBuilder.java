package com.mlg.acciones.service;

/**
 *
 * @author josebermeo
 */
public class ServiceBuilder {
    
    private CompanyService companyService;
    private DateService dateService;
    private MarketService marketService;
    private QuoteService quoteService;
    private StockService stockService;
    
    public CompanyService getCompanyService(){
        if(companyService == null){
            companyService = new CompanyService(null);
        }
        return companyService;
    }
    
    public DateService getDateService(){
        if(dateService == null){
            dateService = new DateService(null);
        }
        return dateService;
    }
    
    public MarketService getMarketService(){
        if(marketService == null){
            marketService = new MarketService(null);
        }
        return marketService;
    }
    
    public QuoteService getQuoteService(){
        if(quoteService == null){
            quoteService = new QuoteService(null);
        }
        return quoteService;
    }
    
    public StockService getStockService(){
        if(stockService == null){
            stockService = new StockService(null);
        }
        return stockService;
    }
}
