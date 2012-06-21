package org.xtremeware.testapp.service;

public class ServiceFactory {


    public UserService getUserService() {
	    return UserService.getInstance();
    }
}
