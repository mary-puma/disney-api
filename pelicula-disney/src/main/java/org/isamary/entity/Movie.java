package org.isamary.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @Column(name="creation_date")
    private Date creation_date;

    @Column(name="score")
    private int score;

    @ManyToMany(fetch = FetchType.EAGER)//para relacionar tablas
    @JoinTable(name = "personage_movie",
            joinColumns=@JoinColumn(name="movie_id"),
            inverseJoinColumns=@JoinColumn(name="personage_id"))
    private List<Character> characters;
}
