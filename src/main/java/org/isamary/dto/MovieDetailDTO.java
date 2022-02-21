package org.isamary.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class MovieDetailDTO {
    private String image;
    private String title;
    private Date creation_date;
    private int score;
    private List<String> characters;

    public MovieDetailDTO(String image, String title, Date creation_date, int score, List<String> characters) {
        this.image = image;
        this.title = title;
        this.creation_date = creation_date;
        this.score = score;
        this.characters = characters;
    }
}
