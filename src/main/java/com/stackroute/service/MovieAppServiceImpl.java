package com.stackroute.service;


import com.stackroute.domain.MovieApp;
import com.stackroute.exceptions.GeneralException;
import com.stackroute.exceptions.MovieAlreadyExistsException;
import com.stackroute.exceptions.MovieNotFoundException;
import com.stackroute.repository.MovieAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieAppServiceImpl implements MovieAppService, ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {

    MovieAppRepository movieAppRepository;

    @Value("${movie.id}")
    private String id;
    @Value("${movie.title}")
    private String title;
    @Value("${movie.genre}")
    private String genre;
    @Value("${movie.language}")
    private String language;


    @Autowired
    public MovieAppServiceImpl(MovieAppRepository movieAppRepository) {
        this.movieAppRepository = movieAppRepository;
    }


    @Override
    public MovieApp saveMovie(MovieApp movie) throws MovieAlreadyExistsException {
        if (movieAppRepository.existsById(movie.getId())) {
            throw new MovieAlreadyExistsException("Movie already exists");
        }
        MovieApp savedmovie = movieAppRepository.save(movie);
        if (savedmovie == null) {
            throw new MovieAlreadyExistsException("Movie already exists");
        }
        return savedmovie;
    }

    @Override
    public List<MovieApp> getAllMovies() throws GeneralException {

        List allMovies=movieAppRepository.findAll();
        if(!allMovies.isEmpty()){
            return allMovies; }
        else{
            throw new GeneralException("Internal Server Error");
        }
    }

    @Override
    public boolean deleteMovie(String movieId) throws MovieNotFoundException {
        if (movieAppRepository.existsById(movieId)) {
            movieAppRepository.deleteById(movieId);
            return true;
        } else {
            throw new MovieNotFoundException("No such id exists to delete ");
        }

    }


   @Override
   public MovieApp getMovieById(String movieId) throws MovieNotFoundException {
       MovieApp movie=new MovieApp();
       Optional<MovieApp> movie1=movieAppRepository.findById(movieId);
        if(movie1.isPresent()){
            movie=movie1.get();
            return  movie;}
        else
            throw new  MovieNotFoundException("No such movie exists with the id");
    }

    @Override
    public MovieApp getMovieByName(String movieName) throws MovieNotFoundException {
        MovieApp movie = new MovieApp();
//       if(movieAppRepository.findByMovieTitle(movieName)==movie.getTitle()){
        Optional<MovieApp> movie1 = movieAppRepository.findByMovieTitle(movieName);
        if (movie1.isPresent()) {
            movie = movie1.get();
            return movie;
        } else
            throw new MovieNotFoundException("No such Movie Title exists");
    }

    @Override
    public MovieApp updateMovie(MovieApp movie) throws MovieNotFoundException {
        MovieApp movie1 = new MovieApp();
        if (movieAppRepository.existsById(movie.getId())) {
            movie1 = movieAppRepository.save(movie);
            return movie1;
        } else
            throw new MovieNotFoundException("Nothing to update");

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        movieAppRepository.save(new MovieApp(id,title,genre,language));

    }

    @Override
    public void run(String... args) throws Exception {
        movieAppRepository.save(new MovieApp(id,title,genre,language));
        }
}



