package com.mlg.acciones.service.stockmeassures;

import com.mlg.acciones.entity.QuoteEntity;
import com.mlg.acciones.service.StockMeassure;
import java.util.List;

/**
 *
 * @author josebermeo
 */
public class StockLowPrice implements StockMeassure{

    @Override
    public double getMeassureResult(List<QuoteEntity> quoteList) {
        double min = quoteList.get(0).getHigh();
        for(QuoteEntity quoteEntity: quoteList){
            min = Math.min(min, quoteEntity.getHigh());
        }
        return min;
    }
    
}
