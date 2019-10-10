package com.stackroute.controller;

import com.stackroute.domain.MovieApp;
import com.stackroute.exceptions.GeneralException;
import com.stackroute.exceptions.MovieAlreadyExistsException;
import com.stackroute.exceptions.MovieNotFoundException;
import com.stackroute.service.MovieAppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/api")
public class MovieAppcontroller {


    MovieAppService movieAppService;

    public MovieAppcontroller(MovieAppService movieService) {
        this.movieAppService = movieService;
    }

    @PostMapping("movie")
    public ResponseEntity<?> saveMovie(@RequestBody MovieApp movie) {
        ResponseEntity responseEntity;
     try{
            movieAppService.saveMovie(movie);
            responseEntity = new ResponseEntity("Succesfully Created", HttpStatus.CREATED);
        } catch (MovieAlreadyExistsException ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("allMovies")
    public ResponseEntity<?> getAllMovies()  {
        try {
            return new ResponseEntity<List<MovieApp>>(movieAppService.getAllMovies(), HttpStatus.OK);
        }
        catch (GeneralException ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("movie")
    public ResponseEntity<?> searchByMovieName(@RequestBody String movieName) {
        try {
            return new ResponseEntity(movieAppService.getMovieByName(movieName), HttpStatus.OK);
        } catch (MovieNotFoundException ex) {
           return  new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("movie")
    public ResponseEntity<?> deleteMovie(@RequestBody String movieId){
        ResponseEntity responseEntity;
       try{
            movieAppService.deleteMovie(movieId);
            return new ResponseEntity("Succesfully deleted", HttpStatus.OK);
        }catch(MovieNotFoundException ex){
            return new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
        }
    }

    @GetMapping("movie/{id}")
    public ResponseEntity getMovieById(@PathVariable("id") String movieId){
        ResponseEntity responseEntity;
        try{
         return  new ResponseEntity(movieAppService.getMovieById(movieId),HttpStatus.OK);}
         catch(MovieNotFoundException ex){
             return new ResponseEntity<>(ex.getMessage(),HttpStatus.CONFLICT);
            }
    }

    @PutMapping("movie")
    public ResponseEntity<?> updateMovie(MovieApp movie){
        ResponseEntity responseEntity;
        try{
        movieAppService.updateMovie(movie);
        return new ResponseEntity("Succesfully updated",HttpStatus.OK);}
        catch(MovieNotFoundException ex){
            return new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
    }
}

