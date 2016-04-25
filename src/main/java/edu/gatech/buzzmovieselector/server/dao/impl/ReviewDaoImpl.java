package edu.gatech.buzzmovieselector.server.dao.impl;

import edu.gatech.buzzmovieselector.server.dao.ReviewDao;
import edu.gatech.buzzmovieselector.server.entity.Review;

import java.sql.SQLException;

public class ReviewDaoImpl extends DaoImpl<Review, Integer> implements
    ReviewDao {

    // this constructor must be defined
    public ReviewDaoImpl() throws SQLException {
        super(Review.class);
    }
}
