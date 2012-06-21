package com.mlg.acciones.service.stockmeassures;

import com.mlg.acciones.entity.QuoteEntity;
import com.mlg.acciones.service.StockMeassure;
import java.util.List;

/**
 *
 * @author josebermeo
 */
public class StockMaxPrice implements StockMeassure{

    @Override
    public double getMeassureResult(List<QuoteEntity> quoteList) {
        double max = quoteList.get(0).getHigh();
        for(QuoteEntity quoteEntity: quoteList){
            max = Math.max(max, quoteEntity.getHigh());
        }
        return max;
    }
    
}
