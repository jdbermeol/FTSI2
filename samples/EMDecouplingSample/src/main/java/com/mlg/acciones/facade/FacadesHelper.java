package com.mlg.acciones.facade;

import com.mlg.acciones.dao.dataAccess.DataAccessAdapter;

/**
 *
 * @author healarconr
 */
public final class FacadesHelper {

    private FacadesHelper() {
    }

    private static <E extends Exception> void checkException(DataAccessAdapter dataAccessAdapter, Exception exception, Class<E> exceptionClass,
            boolean rollback, boolean closeEntity) throws
            E {
        if (exceptionClass.isInstance(exception)) {
            if (rollback) {
                rollbackTransaction(dataAccessAdapter);
            }
            if (closeEntity) {
                closeEntityManager(dataAccessAdapter);
            }
            throw exceptionClass.cast(exception);
        }
    }

    /**
     * Checks if the exception is an instance of the exception class. If so,
     * rolls back the transaction and then throws the exception.
     *
     * @param entityManager the entity manager
     * @param transaction the transaction
     * @param exception the exception to check
     * @param exceptionClass the exception class
     */
    public static <E extends Exception> void checkExceptionAndRollback(
            DataAccessAdapter dataAccessAdapter, Exception exception, Class<E> exceptionClass) throws
            E {
        checkException(dataAccessAdapter, exception, exceptionClass, true, true);
    }

    public static <E extends Exception> void checkException(DataAccessAdapter dataAccessAdapter,
            Exception ex,
            Class<E> exceptionClass) throws
            E {
        checkException(dataAccessAdapter, ex, exceptionClass, false, true);
    }

    public static <E extends Exception> void checkException(Exception ex,
            Class<E> exceptionClass) throws
            E {
        checkException(null, ex, exceptionClass, false, false);
    }

    /**
     * Silently rolls back a transaction and logs possible exceptions
     *
     * @param em the entity manager
     * @param tx the transaction
     */
    private static void rollbackTransaction(DataAccessAdapter dataAccessAdapter) {

        rollbackTransactionAndCloseEntityManager(dataAccessAdapter, null);
    }

    /**
     * Rolls back a transaction and throws a RuntimeException to wrap the
     * exception argument
     *
     * @param em the entity manager
     * @param tx the entity transaction
     * @param exception the exception to wrap
     */
    public static void rollbackTransactionAndCloseEntityManager(DataAccessAdapter dataAccessAdapter,
            Exception exception) {

        if (dataAccessAdapter != null) {
            dataAccessAdapter.rollback();
        }
        closeEntityManager(dataAccessAdapter);

        if (exception != null) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * Silently closes the entity manager and logs possible exceptions
     *
     * @param em
     */
    public static void closeEntityManager(DataAccessAdapter dataAccessAdapter) {
        if (dataAccessAdapter != null) {
            dataAccessAdapter.close();
        }
    }
}
