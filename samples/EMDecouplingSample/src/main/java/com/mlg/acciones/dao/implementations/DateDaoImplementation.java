package com.mlg.acciones.dao.implementations;

import com.mlg.acciones.dao.DataBaseException;
import com.mlg.acciones.dao.DateDao;
import com.mlg.acciones.dao.Delete;
import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import com.mlg.acciones.entity.DayEntity;
import com.mlg.acciones.vo.DateVo;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author josebermeo
 */
public class DateDaoImplementation extends CrudDaoImplementation<Long, DayEntity> implements DateDao{

    public DateDaoImplementation(Delete delete) {
        super(delete);
    }

    @Override
    protected Class getEntityClass() {
        return DayEntity.class;
    }

    @Override
    public DayEntity getByYearMonthAndDay(DataAccessAdapter<EntityManager> dataAccessAdapter, 
        DateVo dateVo) 
            throws DataBaseException {
        checkEntityManager(dataAccessAdapter);
        try {
            return dataAccessAdapter.getDataAccess()
                    .createNamedQuery("getDateByYearMonthAndDay",
                    DayEntity.class).setParameter("year", dateVo.getYear()).setParameter("month", dateVo.getMonth())
                    .setParameter("day", dateVo.getDate()).getSingleResult();
        } catch (NoResultException exception) {
            return null;
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage(), e.getCause());
        }
    }
    
}
