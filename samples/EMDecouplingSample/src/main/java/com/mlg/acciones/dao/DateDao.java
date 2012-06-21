package com.mlg.acciones.dao;

import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import com.mlg.acciones.entity.DayEntity;
import com.mlg.acciones.vo.DateVo;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public interface DateDao extends CrudDao<Long, DayEntity> {
    
    DayEntity getByYearMonthAndDay(DataAccessAdapter<EntityManager> dataAccessAdapter, DateVo dateVo)
            throws DataBaseException;
}
