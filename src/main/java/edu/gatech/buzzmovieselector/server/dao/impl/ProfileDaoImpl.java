package edu.gatech.buzzmovieselector.server.dao.impl;

import edu.gatech.buzzmovieselector.server.dao.ProfileDao;
import edu.gatech.buzzmovieselector.server.entity.Profile;

import java.sql.SQLException;

/**
 * Hibernate implementation of the ProfileDao interface.
 */
public class ProfileDaoImpl extends DaoImpl<Profile, Integer>
        implements ProfileDao {

    // this constructor must be defined
    public ProfileDaoImpl() throws SQLException {
        super(Profile.class);
    }

}