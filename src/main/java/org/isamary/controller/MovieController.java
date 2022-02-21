package org.isamary.controller;

import org.isamary.dto.MovieDTO;
import org.isamary.dto.MovieDetailDTO;
import org.isamary.entity.Movie;
import org.isamary.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    private static final String MOVIES = "/movies";
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(MOVIES)
    public List<MovieDTO> movieDTOList(){
        return this.movieService.movieDTOList();
    }
    @GetMapping("/movies/details")
    public List<MovieDetailDTO> movieDetailDTOList(){
        return this.movieService.movieDetailDTOList();
    }

    @PostMapping(MOVIES)
    public Movie salveMovie(@RequestBody Movie movie){
        return this.movieService.saveMovie(movie);
    }
    @DeleteMapping(MOVIES)
    public  void deleteMovie(@RequestBody Movie movie){
        this.movieService.deleteMovie(movie);
    }

    @PutMapping(MOVIES)
    public Movie updateMovie(@RequestBody Movie movie){
        return this.movieService.saveMovie(movie);
    }


}
