package org.xtremeware.testapp.da;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcDataAccessFactory implements AbstractDataAccessFactory {

    private String connectionString;
    private Properties properties;

    public JdbcDataAccessFactory(String connectionString, Properties properties) {
        this.connectionString = connectionString;
        this.properties = properties;
    }

    public DataAccessAdapter createDataAccess() throws DataAccessException {
        try {
            return new JdbcDataAccess(DriverManager.getConnection(connectionString, properties));
        } catch (SQLException ex) {
            throw new DataAccessException(ex);
        }
    }
}
