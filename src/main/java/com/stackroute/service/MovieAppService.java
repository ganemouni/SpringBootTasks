package com.stackroute.service;

import com.stackroute.domain.MovieApp;
import com.stackroute.exceptions.GeneralException;
import com.stackroute.exceptions.MovieAlreadyExistsException;
import com.stackroute.exceptions.MovieNotFoundException;

import java.util.List;

public interface MovieAppService {

    public MovieApp saveMovie(MovieApp movie) throws MovieAlreadyExistsException;
    public List<MovieApp> getAllMovies()throws GeneralException;
    public boolean deleteMovie(String movieId) throws MovieNotFoundException;
    public MovieApp getMovieByName(String movieName) throws MovieNotFoundException;
    public MovieApp updateMovie(MovieApp movie)throws MovieNotFoundException;
    public MovieApp getMovieById(String movieId)throws MovieNotFoundException ;
}

