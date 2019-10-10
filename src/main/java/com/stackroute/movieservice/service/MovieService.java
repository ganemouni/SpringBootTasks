package com.stackroute.movieservice.service;
import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
import javassist.NotFoundException;

import java.util.List;


public interface MovieService {
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException;
    public List<Movie> getAllMovies();
    public boolean deleteMovie(int id);
    boolean updateMovie(Movie movie) throws NotFoundException;
    public Movie getMovieByName(String movieTitle);
}
