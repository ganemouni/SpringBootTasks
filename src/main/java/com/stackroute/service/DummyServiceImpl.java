package com.stackroute.service;


import com.stackroute.domain.MovieApp;
import com.stackroute.exceptions.GeneralException;
import com.stackroute.exceptions.MovieAlreadyExistsException;
import com.stackroute.exceptions.MovieNotFoundException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dummyService")
@Profile("tempProfile")
public class DummyServiceImpl  implements MovieAppService, ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {
    @Override
    public MovieApp saveMovie(MovieApp movie) throws MovieAlreadyExistsException {
        return null;
    }

    @Override
    public List<MovieApp> getAllMovies() throws GeneralException {
        return null;
    }

    @Override
    public boolean deleteMovie(String movieId) throws MovieNotFoundException {
        return false;
    }

    @Override
    public MovieApp getMovieByName(String movieName) throws MovieNotFoundException {
        return null;
    }

    @Override
    public MovieApp updateMovie(MovieApp movie) throws MovieNotFoundException {
        return null;
    }

    @Override
    public MovieApp getMovieById(String movieId) throws MovieNotFoundException {
        return null;
    }

    @Override
    public void run(String... args) throws Exception {

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

    }
}
