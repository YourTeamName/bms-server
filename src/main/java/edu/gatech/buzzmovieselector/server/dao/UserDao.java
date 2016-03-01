package edu.gatech.buzzmovieselector.server.dao;

import edu.gatech.buzzmovieselector.server.entity.User;

/**
 * User DAO which has a String id (User.username)
 */
public interface UserDao extends Dao<User, String> {
}
