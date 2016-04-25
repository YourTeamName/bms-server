package edu.gatech.buzzmovieselector.server.dao.impl;

import edu.gatech.buzzmovieselector.server.dao.MovieDao;
import edu.gatech.buzzmovieselector.server.entity.Movie;

import java.sql.SQLException;


public class MovieDaoImpl extends DaoImpl<Movie, Integer> implements MovieDao {

    // this constructor must be defined
    public MovieDaoImpl() throws SQLException {
        super(Movie.class);
    }
}
