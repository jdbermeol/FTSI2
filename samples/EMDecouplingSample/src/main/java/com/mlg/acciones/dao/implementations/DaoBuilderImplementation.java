package com.mlg.acciones.dao.implementations;

import com.mlg.acciones.dao.*;
import com.mlg.acciones.dao.implementations.deleteimplementations.*;
import com.mlg.acciones.entity.*;

/**
 *
 * @author josebermeo
 */
public class DaoBuilderImplementation implements AbstractDaoBuilder {
    
    private CompanyDao companyDao;
    private DateDao dateDao;
    private MarketDao marketDao;
    private QuoteDao quoteDao;
    private StockDao stockDao;
    private UserDao userDao;

    public DaoBuilderImplementation() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    

    @Override
    public CompanyDao getCompanyDao() {
        if (companyDao == null) {
            companyDao = new CompanyDaoImplementation(new CompanyDeleteBehavior(
                    this, new SimpleDeleteBehavior<CompanyEntity>()));  
        }
        return companyDao;
    }

    @Override
    public DateDao getDateDao() {
        if (dateDao == null) {
            dateDao = new DateDaoImplementation(new SimpleDeleteBehavior<DayEntity>());  
        }
        return dateDao;
    }

    @Override
    public MarketDao getMarketDao() {
        if (marketDao == null) {
            marketDao = new MarketDaoImplementation(new SimpleDeleteBehavior<MarketEntity>());  
        }
        return marketDao;
    }

    @Override
    public QuoteDao getQuoteDao() {
        if (quoteDao == null) {
            quoteDao = new QuoteDaoImplementation(new SimpleDeleteBehavior<QuoteEntity>());  
        }
        return quoteDao;
    }

    @Override
    public StockDao getStockDao() {
        if (stockDao == null) {
            stockDao = new StockDaoImplementation(new StockDeleteBehavior(
                    this, new SimpleDeleteBehavior<StockEntity>()));  
        }
        return stockDao;
    }

    @Override
    public UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImplementation(new SimpleDeleteBehavior<UserEntity>());  
        }
        return userDao;
    }
    
}
