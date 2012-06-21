package org.xtremeware.testapp.helper;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xtremeware.testapp.da.AbstractDataAccessFactory;
import org.xtremeware.testapp.da.JdbcDataAccessFactory;
import org.xtremeware.testapp.da.JpaDataAccessFactory;
import org.xtremeware.testapp.facade.FacadeBuilder;
import org.xtremeware.testapp.service.ServiceFactory;

@SuppressWarnings("StaticNonFinalUsedInInitialization")
public final class Application {

    private static final String appName = "testapp";
    private static AbstractDataAccessFactory dataAccessAdapterFactory;
    private static ServiceFactory serviceBuilder;
    private static FacadeBuilder facadeBuilder;

    static {
        Properties properties = new Properties();
        try {
            properties.load(Application.class.getResourceAsStream("/org/xtremeware/" + appName + "/application.properties"));
            String dataAccess = properties.getProperty("dataAccess");
            if (dataAccess == null){
                throw new NullPointerException("dataAccess propertie cannot be Null");
            }
            if (dataAccess.equals("jdbc")) {
                final String prefix = "jdbc.properties.";
                String connectionString = properties.getProperty("jdbc.connectionString");
                Properties connectionProperties = new Properties();
                Set<Object> keySet = properties.keySet();
                String stringKey;
                for (Object key : keySet) {
                    stringKey = key.toString();
                    if (stringKey.startsWith(prefix)) {
                        connectionProperties.put(stringKey.substring(stringKey.indexOf(prefix) + prefix.length()), properties.getProperty(stringKey));
                    }
                }
                dataAccessAdapterFactory = new JdbcDataAccessFactory(connectionString, connectionProperties);
            } else if (dataAccess.equals("jpa")) {
                dataAccessAdapterFactory = new JpaDataAccessFactory(properties.getProperty("jpa.persistenceUnit"));
            }
            serviceBuilder = new ServiceFactory();
            facadeBuilder = new FacadeBuilder(dataAccessAdapterFactory, serviceBuilder);
        } catch (IOException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static AbstractDataAccessFactory getDataAccessAdapterFactory() {
        return dataAccessAdapterFactory;
    }

    public static ServiceFactory getServiceBuilder() {
        return serviceBuilder;
    }

    public static FacadeBuilder getFacadeBuilder() {
        return facadeBuilder;
    }
}
