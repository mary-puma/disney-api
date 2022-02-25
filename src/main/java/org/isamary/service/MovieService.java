package org.isamary.service;

import org.isamary.dto.MovieDTO;
import org.isamary.dto.MovieDetailDTO;
import org.isamary.entity.Movie;
import org.isamary.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    public List<MovieDetailDTO> movieDetailDTOList(){
        return convertMovieListToMovieDetailDTOList(movieRepository.findAll());
    }

    public List<MovieDetailDTO> convertMovieListToMovieDetailDTOList(List<Movie> movies){
        return movies
                .stream()
                .map(Movie::convertMovieToMovieDetailDTO)
                .collect(Collectors.toList());
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(String title) {
     movieRepository.deleteMovieByTitle(title);
    }

    public List<MovieDTO> movieDTOListByTitle(String title){
        return convertMovieListToMovieDTOList(movieRepository.findMovieByTitle(title));
    }

    public List<MovieDTO> movieDTOListByGenre(String genre){
        return convertMovieListToMovieDTOList(movieRepository.findMovieByGenre(genre));
    }

    public List<MovieDTO> movieDTOListOrderByCreationDate(Sort.Direction order){
        if(order.isDescending())
            return convertMovieListToMovieDTOList(movieRepository.orderByCreationDateDesc());
        else
            return convertMovieListToMovieDTOList(movieRepository.orderByCreationDateAsc());
    }


}
