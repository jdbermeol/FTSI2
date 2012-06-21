package com.mlg.acciones.dao;

import com.mlg.acciones.entity.DayEntity;
import com.mlg.acciones.vo.DateVo;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public interface DateDao extends CrudDao<DayEntity> {
    DayEntity getByYearMonthAndDay(EntityManager entityManager, DateVo dateVo)
            throws DataBaseException;
}
