package com.stackroute.prefill;


import com.stackroute.domain.MovieApp;
import com.stackroute.repository.MovieAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerDemo implements CommandLineRunner {

    @Autowired
    private MovieAppRepository movieAppRepository;
    @Override
    public void run(String... args) throws Exception {
        seedData();
    }
    private void seedData(){
//        movieAppRepository.save(new MovieApp("1","Piku","drama","hindi"));
//        movieAppRepository.save(new MovieApp("2","Avengers:Infinity-War","Action,Fantasy","English"));
//        movieAppRepository.save(new MovieApp("3","Badla","Thriller","hindi"));
//        movieAppRepository.save(new MovieApp("4","Syera","Drama","Telugu"));

    }
}
