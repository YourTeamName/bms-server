package edu.gatech.buzzmovieselector.server.dao.impl;

import edu.gatech.buzzmovieselector.server.dao.UserDao;
import edu.gatech.buzzmovieselector.server.entity.User;

import java.sql.SQLException;

/**
 * Hibernate implementation of the UserDao interface.
 */
public class UserDaoImpl extends DaoImpl<User, String>
        implements UserDao {

    // this constructor must be defined
    public UserDaoImpl() throws SQLException {
        super(User.class);
    }

}
