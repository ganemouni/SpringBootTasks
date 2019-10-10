package com.stackroute.movieservice.service;
import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;
import javassist.NotFoundException;

import java.util.List;


public interface MovieService {
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException;
    public List<Movie> getAllMovies();
    public boolean deleteMovie(int id) throws MovieNotFoundException;
    public boolean updateMovie(Movie movie) throws MovieNotFoundException;
    public Movie getMovieByName(String movieTitle) throws MovieNotFoundException;
}
