package com.mlg.acciones.service;

/**
 *
 * @author josebermeo
 */
public class DataException extends Exception{

    public DataException(Throwable thrwbl) {
        super(thrwbl);
    }

    public DataException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public DataException(String string) {
        super(string);
    }

    public DataException() {
    }
    
}
