package org.isamary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterController {

    private static final String CHARACTERS = "/characters";

    @GetMapping(CHARACTERS)
    public String getCharacters(){
        return "marylindaguba";
    }



}
