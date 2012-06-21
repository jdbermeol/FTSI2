package com.mlg.acciones.facade;

import com.mlg.acciones.dao.dataAccess.AbstractDataAccessFactory;
import com.mlg.acciones.vo.DateVo;

public class DateFacade {

    AbstractDataAccessFactory dataSource;

    public DateFacade(AbstractDataAccessFactory dataSource) {
        this.dataSource = dataSource;
    }

    public DateVo getOrCreateDate(int date, int month, int year) {
        return null;
    }

    public DateVo getDate(long dateId) {
        return null;
    }
}
