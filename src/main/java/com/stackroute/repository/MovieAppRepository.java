package com.stackroute.repository;

import com.stackroute.domain.MovieApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieAppRepository extends JpaRepository<MovieApp,String> {

    @Query(value="Select * from movie where  movie.title=:title",nativeQuery = true)
    public Optional<MovieApp> findByMovieTitle(@Param("title") String title);
}
