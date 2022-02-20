package org.isamary.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class MovieDTO {

    private String image;
    private String title;
    private Date creation_date;

    public MovieDTO(String image, String title, Date creation_date) {
        this.image = image;
        this.title = title;
        this.creation_date = creation_date;
    }
}
