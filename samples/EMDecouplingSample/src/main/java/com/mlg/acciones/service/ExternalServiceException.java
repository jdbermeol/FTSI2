package com.mlg.acciones.service;

/**
 *
 * @author josebermeo
 */
class ExternalServiceException extends RuntimeException {

    public ExternalServiceException(Throwable thrwbl) {
        super(thrwbl);
    }

    public ExternalServiceException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ExternalServiceException(String string) {
        super(string);
    }

    public ExternalServiceException() {
    }
}
