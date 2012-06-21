package com.mlg.acciones.dao;

/**
 *
 * @author josebermeo
 */
public class DataBaseException extends Exception {

    public DataBaseException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public DataBaseException(String string) {
        super(string);
    }

    public DataBaseException() {
    }
}
    

