package org.isamary.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CharacterDetailDTO {
    private String image;
    private String name;
    private int age;
    private String history;
    private float weight;
    private List<String> movies;

    public CharacterDetailDTO(String image, String name, int age, String history, float weight, List<String> movies) {
        this.image = image;
        this.name = name;
        this.age = age;
        this.history = history;
        this.weight = weight;
        this.movies = movies;
    }
}
