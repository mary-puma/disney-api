package org.isamary.controller;

import org.isamary.dto.MovieDTO;
import org.isamary.dto.MovieDetailDTO;
import org.isamary.entity.Movie;
import org.isamary.service.MovieService;
import org.springframework.data.domain.Sort;
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
    public List<MovieDTO> movieDTOList(
            @RequestParam(name="title",required = false) String title,
            @RequestParam(name="genre",required = false) String genre,
            @RequestParam(name = "order", required = false) Sort.Direction order){
        List<MovieDTO> movieDTOList;
        if (title!=null){
            movieDTOList=movieService.movieDTOListByTitle(title);
        }else if (genre!=null){
            movieDTOList = movieService.movieDTOListByGenre(genre);
        }else if (order!=null){
            movieDTOList = movieService.movieDTOListOrderByCreationDate(order);
        } else {
            movieDTOList = movieService.movieDTOList();
        }
        return movieDTOList;
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
