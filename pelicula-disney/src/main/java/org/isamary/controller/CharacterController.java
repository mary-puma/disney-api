package org.isamary.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class CharacterController {

    private static final String CHARACTERS = "/characters";

    @GetMapping(CHARACTERS)
    public String getCharacters(){
        return "marylindaguba";
    }

    @PostMapping(CHARACTERS)
    public String createCharacter(){
        return "created character";
    }

    @DeleteMapping(CHARACTERS)
    public String deleteCharacter(){
        return "delete character";
    }

    @PutMapping(CHARACTERS)
    public String updateCharacter(){
        return "update character";
    }



}
