package org.isamary.service;


import org.isamary.dto.CharacterDTO;
import org.isamary.dto.MovieDTO;
import org.isamary.entity.Movie;
import org.isamary.repository.CharacterRepository;
import org.isamary.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<MovieDTO> movieDTOList(){
        return convertMovieListToMovieDTOList(movieRepository.findAll());
    }
    public List<MovieDTO> convertMovieListToMovieDTOList(List<Movie> movies){
        return movies
                .stream()
                .map(Movie::convertMovieToMovieDTO)
                .collect(Collectors.toList());
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);

    }

    public void deleteMovie(Movie movie) {
     movieRepository.delete(movie);
    }
}
