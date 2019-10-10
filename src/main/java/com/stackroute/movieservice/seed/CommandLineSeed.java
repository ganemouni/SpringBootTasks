package com.stackroute.movieservice.seed;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineSeed implements CommandLineRunner {

    private MovieRepository movieRepository;


    @Autowired
    public CommandLineSeed(MovieRepository movieRepository) {
        this.movieRepository=movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Movie movie=new Movie(2,"Queen","Overview Comming Soon","Hindi");
        Movie movie1=new Movie(3,"RRR","PAN India Movie","Telugu");
        movieRepository.save(movie);
        movieRepository.save(movie1);
    }
}
