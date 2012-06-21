package org.xtremeware.testapp.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.xtremeware.testapp.da.DataAccessAdapter;
import org.xtremeware.testapp.da.DataAccessException;
import com.mlg.acciones.dao.UserDao;
import com.mlg.acciones.vo.UserVo;

public class UserJdbcDao implements UserDao<Connection> {

	private final String table_name = " usertest ";
	private static UserJdbcDao instance = null;

	private UserJdbcDao(){}

	public static UserJdbcDao getInstance(){
		if (instance == null){
			instance = new UserJdbcDao();
		}
		return instance;
	}

    public UserVo insert(DataAccessAdapter<Connection> adapter, UserVo vo)
            throws DataAccessException {
        try {
            Connection c = adapter.getDataAccess();
            PreparedStatement s = c.prepareStatement(
                    "INSERT INTO" + table_name + "(user_name, password) values (?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            ResultSet r;
            s.setString(1, vo.getUserName());
            s.setString(2, vo.getPassword());
            if (s.executeUpdate() != 1) {
                throw new DataAccessException(
                        "An user insertion didn't affect one record");
            }
            r = s.getGeneratedKeys();
            r.next();

            return new UserVo(r.getLong(1), vo.getUserName(), vo.getPassword());
        } catch (SQLException ex) {
            throw new DataAccessException(ex);
        }
    }

    public UserVo update(DataAccessAdapter<Connection> adapter, UserVo vo)
            throws DataAccessException {
        try {
            Connection c = adapter.getDataAccess();
            PreparedStatement s = c.prepareStatement(
                    "UPDATE" + table_name + "SET user_name = ?, password = ? WHERE id = ?");
            s.setString(1, vo.getUserName());
            s.setString(2, vo.getPassword());
            s.setLong(3, vo.getId());
            if (s.executeUpdate() != 1) {
                throw new DataAccessException(
                        "An user update didn't affect one record");
            }
            return vo;
        } catch (SQLException ex) {
            throw new DataAccessException(ex);
        }
    }

    public void delete(DataAccessAdapter<Connection> adapter, long id) throws
            DataAccessException {
        try {
            Connection c = adapter.getDataAccess();
            PreparedStatement s = c.prepareStatement(
                    "DELETE FROM" + table_name + "WHERE id = ?");
            s.setLong(1, id);
            if (s.executeUpdate() != 1) {
                throw new DataAccessException(
                        "An user delete didn't affect one record");
            }
        } catch (SQLException ex) {
            throw new DataAccessException(ex);
        }
    }

    public UserVo findById(DataAccessAdapter<Connection> adapter, long id)
            throws DataAccessException {
        try {
            Connection c = adapter.getDataAccess();
            PreparedStatement s = c.prepareStatement(
                    "SELECT user_name, password FROM" + table_name + "WHERE id = ?");
            ResultSet r;
            s.setLong(1, id);
            r = s.executeQuery();
            if (r.next()) {
                return new UserVo(id, r.getString(1), r.getString(2));
            } else {
                return null;
            }
        } catch (SQLException ex) {
            throw new DataAccessException(ex);
        }
    }

    public UserVo findByUserNameAndPassword(
            DataAccessAdapter<Connection> adapter, String userName,
            String password) throws DataAccessException {
        try {
            Connection c = adapter.getDataAccess();
            PreparedStatement s = c.prepareStatement(
                    "SELECT id FROM" + table_name + " WHERE user_name = ? AND password = ?");
            ResultSet r;
            s.setString(1, userName);
            s.setString(2, password);
            r = s.executeQuery();
            if (r.next()) {
                return new UserVo(r.getLong(1), userName, password);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            throw new DataAccessException(ex);
        }
    }
}
