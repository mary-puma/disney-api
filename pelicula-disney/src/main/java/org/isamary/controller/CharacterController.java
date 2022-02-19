package org.isamary.controller;

import org.isamary.entity.Character;
import org.isamary.repository.CharacterRepository;
import org.isamary.service.CharacterService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CharacterController {

    private static final String CHARACTERS = "/characters";

    private final CharacterService characterService;


    public CharacterController(CharacterService characterService){
        this.characterService = characterService;
    }


    @GetMapping(CHARACTERS)
    public List<Character> getCharacters(
            @RequestParam(name="name",required = false) String name,
            @RequestParam(name="age",required = false) Integer age,
            @RequestParam(name="movie",required = false) String movie){
        List<Character> characterList;

        if(name!=null){
            characterList = characterService.listAllByName(name);
        }else if(age!=null){
            characterList = characterService.listAllByAge(age);
        }else if (movie!=null){
            characterList = characterService.listAllByMovie(movie);
        }else {
            characterList = characterService.listAll();
        }
        return characterList;//devuelve la lista de personajes
    }

    @PostMapping(CHARACTERS)
    public  Character saveCharacter(@RequestBody Character character){
        return this.characterService.save(character);
    }

    @DeleteMapping(CHARACTERS)
    public void deleteCharacter(@RequestBody Character character){
         this.characterService.delete(character);
    }

    @PutMapping(CHARACTERS)
    public Character updateCharacter(@RequestBody Character character){
         return this.characterService.save(character);
    }

}
