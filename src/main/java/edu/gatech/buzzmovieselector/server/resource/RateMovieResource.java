package edu.gatech.buzzmovieselector.server.resource;

import edu.gatech.buzzmovieselector.server.dao.MovieDao;
import edu.gatech.buzzmovieselector.server.dao.ReviewDao;
import edu.gatech.buzzmovieselector.server.dao.impl.MovieDaoImpl;
import edu.gatech.buzzmovieselector.server.dao.impl.ReviewDaoImpl;
import edu.gatech.buzzmovieselector.server.entity.Movie;
import edu.gatech.buzzmovieselector.server.entity.Review;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/rateMovie")
public class RateMovieResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Review rateMovie(Review review) {
        Review newReview = null;
        Movie movie = null;
        try {
            ReviewDao reviewDao = new ReviewDaoImpl();
            MovieDao movieDao = new MovieDaoImpl();
            movie = movieDao.findById(review.getMovie().getId());
            if (movie == null) {
                movie = review.getMovie();
                ArrayList<Review> newReviews = new ArrayList<Review>();
                newReviews.add(review);
                movie.setReviews(newReviews);
                movieDao.createOrUpdate(movie);
            }
            reviewDao.createOrUpdate(review);
            movie.getReviews().add(review);
            movieDao.createOrUpdate(movie);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return review;
    }
}
