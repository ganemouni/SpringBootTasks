package com.stackroute.movieservice.service;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.repository.MovieRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceImpl implements  MovieService {
    MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
        if (movieRepository.existsById(movie.getId())||movie==null){
            throw new MovieAlreadyExistsException("Movie already exits unable to save");
        }
        else {
            Movie movie1=movieRepository.save(movie);
            return movie1;}
    }

    @Override
    public List<Movie> getAllMovies() {

        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(int id) throws NotFoundException {
        Movie movie=movieRepository.findById(id).orElseThrow(() -> new NotFoundException("No Movie found with Id  " + id));
        return movie;
    }

    @Override
    public boolean deleteMovie(int id) {

        movieRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean updateMovie(Movie movie) throws NotFoundException {
        Movie movie1=movieRepository.findById(movie.getId()).orElseThrow(() -> new NotFoundException("No Movie found with Id  " + movie.getId()));
        movieRepository.save(movie);
        return true;
    }
}
