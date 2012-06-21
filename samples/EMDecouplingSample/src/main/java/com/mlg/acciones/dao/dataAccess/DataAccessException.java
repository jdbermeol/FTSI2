package com.mlg.acciones.dao.dataAccess;

/**
 *
 * @author josebermeo
 */
public class DataAccessException extends RuntimeException {

    public DataAccessException(Throwable thrwbl) {
        super(thrwbl);
    }

    public DataAccessException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public DataAccessException(String string) {
        super(string);
    }

    public DataAccessException() {
    }
}
