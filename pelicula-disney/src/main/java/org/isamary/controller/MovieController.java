package org.isamary.controller;

import org.isamary.entity.Movie;
import org.isamary.repository.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    private static final String MOVIES = "/movies";
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping(MOVIES)
    public List<Movie> getMovies(){
        return this.movieRepository.findAll();
    }

    @PostMapping(MOVIES)
    public Movie salveMovie(@RequestBody Movie movie){
        return this.movieRepository.save(movie);
    }
    @DeleteMapping(MOVIES)
    public  void deleteMovie(@RequestBody Movie movie){
        this.movieRepository.delete(movie);
    }

    @PutMapping(MOVIES)
    public Movie updateMovie(@RequestBody Movie movie){
        return this.movieRepository.save(movie);
    }


}
