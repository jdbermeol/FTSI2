package com.mlg.acciones.facade;

import com.mlg.acciones.dao.dataAccess.AbstractDataAccessFactory;
import com.mlg.acciones.service.ServiceBuilder;

/**
 *
 * @author Owner
 */
public class FacadeFactory implements FacadeFactoryInterface {

    private MarketFacade marketFacade;
    private CompanyFacade companyFacade;
    private StockFacade stockFacade;
    private QuoteFacade quoteFacade;
    private AbstractDataAccessFactory generalSource;
    private AbstractDataAccessFactory authenticationSource;
    private ServiceBuilder serviceBuilder;
    private DateFacade dateFacade;

    public FacadeFactory(AbstractDataAccessFactory generalSource, 
            AbstractDataAccessFactory authenticationSource,
            ServiceBuilder serviceBuilder) {
        this.generalSource = generalSource;
        this.authenticationSource = authenticationSource;
        this.serviceBuilder = serviceBuilder;
    }

    @Override
    public MarketFacade getMarketFacade() {
        if (marketFacade == null) {
            marketFacade = new MarketFacade(generalSource,serviceBuilder);
        }
        return marketFacade;
    }

    @Override
    public CompanyFacade getCompanyFacade() {
        if (companyFacade == null) {
            companyFacade = new CompanyFacade(generalSource);
        }
        return companyFacade;
    }

    @Override
    public StockFacade getStockFacade() {
        if (stockFacade == null) {
            stockFacade = new StockFacade(generalSource);
        }
        return stockFacade;
    }

    @Override
    public QuoteFacade getQuoteFacade() {
        if (quoteFacade == null) {
            quoteFacade = new QuoteFacade(generalSource);
        }
        return quoteFacade;
    }

    @Override
    public DateFacade getDateFacade() {
        if (dateFacade == null) {
            dateFacade = new DateFacade(generalSource);
        }
        return dateFacade;
    }
}
