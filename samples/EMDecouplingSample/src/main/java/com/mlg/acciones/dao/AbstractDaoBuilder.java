package com.mlg.acciones.dao;

public interface AbstractDaoBuilder {
        
        CompanyDao getCompanyDao();
        
        DateDao getDateDao();
        
        MarketDao getMarketDao();
        
        QuoteDao getQuoteDao();
       
        StockDao getStockDao();
        
        UserDao getUserDao();
}
