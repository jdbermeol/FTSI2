package org.xtremeware.testapp.facade;

import junit.framework.TestCase;
import org.junit.Test;
import org.xtremeware.testapp.helper.Application;
import com.mlg.acciones.vo.UserVo;

public class UserFacadeTest extends TestCase {

    @Test
    public void testUserFacade() {
        UserVo user = new UserVo(null, "user", "password");
        UserFacade facade = Application.getFacadeBuilder().getUserFacade();
        user = facade.createUser(user);
        assertNotNull(user.getId());
        UserVo result = facade.findUserById(user.getId());
        assertEquals(result, user);
        user.setUserName("cool name");
        user.setPassword("stronger password");
        result = facade.updateUser(user);
        assertEquals(result, user);
        result = facade.authenticateUser(user.getUserName(), user.getPassword());
        assertEquals(result, user);
        facade.removeUser(user.getId());
    }
}
