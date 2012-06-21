package com.mlg.acciones.service;

import com.mlg.acciones.dao.DataBaseException;
import com.mlg.acciones.dao.DateDao;
import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;
import com.mlg.acciones.entity.DayEntity;
import com.mlg.acciones.vo.DateVo;
import javax.persistence.EntityManager;

/**
 *
 * @author josebermeo
 */
public class DateService {
    
    private DateDao dateDao;

    public DateService(DateDao dateDao) {
        this.dateDao = dateDao;
    }

    public DateVo create(DataAccessAdapter<EntityManager> dataAccessAdapter, 
            DateVo dateVo) throws
            DataBaseException, DataException {
        validateVoForCreation(dataAccessAdapter, dateVo);
        DayEntity dayEntity = voToEntity(dateVo);
        dateDao.create(dataAccessAdapter, dayEntity);
        return dayEntity.toVo();
    }
    
    private void validateVoForCreation(DataAccessAdapter<EntityManager> dataAccessAdapter,
            DateVo dateVo) throws DataException, DataBaseException {
        validateContent(dataAccessAdapter, dateVo);
        if(dateVo.getId() != null){
            throw new DataException("dateVo.id.notNull");
        }
    }
    
    private void validateContent(DataAccessAdapter<EntityManager> dataAccessAdapter,
            DateVo dateVo) throws DataException, DataBaseException {
        if (dateVo == null) {
            throw new DataException("dateVo.null");
        }
        if (dateVo.getDate()<0 || dateVo.getDate()>31) {
            throw new DataException("dateVo.date.incorrect");
        }
        if (dateVo.getMonth()<0 || dateVo.getMonth()>12) {
            throw new DataException("dateVo.month.incorrect");
        }
        if (dateVo.getYear()<0) {
            throw new DataException("dateVo.year.incorrect");
        }
    }

    public DateVo read(DataAccessAdapter<EntityManager> dataAccessAdapter, long valueObjectid) 
            throws DataBaseException {
        DayEntity dayEntity = dateDao.read(dataAccessAdapter, valueObjectid);
        if (dayEntity == null) {
            return null;
        } else {
            return dayEntity.toVo();
        }
    }

    public void delete(DataAccessAdapter<EntityManager> dataAccessAdapter, long valueObjectid)
            throws DataBaseException {
        dateDao.delete(dataAccessAdapter, valueObjectid);
    }

    public DateVo update(DataAccessAdapter<EntityManager> dataAccessAdapter, DateVo dateVo)
            throws DataBaseException {
        DayEntity dayEntity = dateDao.update(dataAccessAdapter, voToEntity(dateVo));
        if (dayEntity != null) {
            return dayEntity.toVo();
        } else {
            return null;
        }
    }
    
    private void validateVoForUpdate(DataAccessAdapter<EntityManager> dataAccessAdapter,
            DateVo dateVo) throws DataException, DataBaseException {
        validateContent(dataAccessAdapter, dateVo);
        if(dateVo.getId() == null){
            throw new DataException("dateVo.id.null");
        } else if(dateDao.read(dataAccessAdapter, dateVo.getId()) == null) {
            throw new DataException("dateVo.notElementFound");
        }
    }
    
    public DateVo getByYearMonthAndDay(DataAccessAdapter<EntityManager> dataAccessAdapter,
            DateVo dateVo) 
            throws DataBaseException{
        return dateDao.getByYearMonthAndDay(dataAccessAdapter, dateVo).toVo();
    }

    private DayEntity voToEntity(DateVo dateVo) {
        DayEntity dayEntity = new DayEntity();
        dayEntity.setId(dateVo.getId());
        dayEntity.setDate(dateVo.getDate());
        dayEntity.setMonth(dateVo.getMonth());
        dayEntity.setYear(dateVo.getYear());
        return null;
    }
}

