package org.isamary.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CharacterDTO {

    private String image;
    private String name;

    public CharacterDTO(String image, String name) {
        this.image = image;
        this.name = name;
    }



}
