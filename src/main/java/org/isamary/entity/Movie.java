package org.isamary.entity;


import lombok.Getter;
import lombok.Setter;
import org.isamary.dto.MovieDTO;
import org.isamary.dto.MovieDetailDTO;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="movie")
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="image")
    private String image;

    @Column(name="title")
    private String title;

    @Temporal (TemporalType.DATE)
    @Column(name="creation_date")
    private Date creation_date;

    @Column(name="score")
    private int score;

    @ManyToMany()//para relacionar tablas
    @JoinTable(name = "personage_movie",
            joinColumns=@JoinColumn(name="movie_id"),
            inverseJoinColumns=@JoinColumn(name="personage_id"))
    private List<Character> characters;

    public MovieDTO convertMovieToMovieDTO(){
        return new MovieDTO(getImage(),getTitle(),getCreation_date());
    }

    public MovieDetailDTO convertMovieToMovieDetailDTO(){
        List<String> charactersName = characters
                .stream()
                .map(Character::getName)
                .collect(Collectors.toList());
        return new MovieDetailDTO(getImage(),getTitle(),getCreation_date(),getScore(),charactersName);

    }

    @ManyToMany()
    @JoinTable(name = "movie_genre",
            joinColumns=@JoinColumn(name="movie_id"),
            inverseJoinColumns=@JoinColumn(name="genre_id"))
    private List<Genre> genres;

}
