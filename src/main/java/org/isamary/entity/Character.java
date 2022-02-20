package org.isamary.entity;

import lombok.Getter;
import lombok.Setter;
import org.isamary.dto.CharacterDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="personage")
@Getter
@Setter
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="image")
    private String image;

    @Column(name="name", unique = true)
    private String name;

    @Column(name="age")
    private int age;

    @Column(name="history")
    private String history;

    @Column(name="weight")
    private float weight;

    @ManyToMany(fetch = FetchType.EAGER)//para relacionar tablas
    @JoinTable(name = "personage_movie",
            joinColumns=@JoinColumn(name="personage_id"),
            inverseJoinColumns=@JoinColumn(name="movie_id"))
    private List<Movie> movies;

    public CharacterDTO convertCharacterToCharacterDTO(){
        return new CharacterDTO(this.getImage(), this.getName()) ;
    }

}
