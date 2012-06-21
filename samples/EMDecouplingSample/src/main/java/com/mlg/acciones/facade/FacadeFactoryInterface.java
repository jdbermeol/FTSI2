/*
 */
package com.mlg.acciones.facade;

/**
 *
 * @author tuareg
 */
public interface FacadeFactoryInterface {
	MarketFacade getMarketFacade();
	CompanyFacade getCompanyFacade();
	StockFacade getStockFacade();
	QuoteFacade getQuoteFacade();
	DateFacade getDateFacade();
}
