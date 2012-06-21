package com.mlg.acciones.service;

import com.mlg.acciones.entity.QuoteEntity;
import java.util.List;

/**
 *
 * @author josebermeo
 */
public interface StockMeassure {
    double getMeassureResult(List<QuoteEntity> quoteList);
}
