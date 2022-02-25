package org.isamary.controller;

import org.isamary.dto.CharacterDTO;
import org.isamary.dto.CharacterDetailDTO;
import org.isamary.entity.Character;
import org.isamary.service.CharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class CharacterController {

    private static final String CHARACTERS = "/characters";
    private static final String CHARACTERS_DETAIL = "/characters/detail";
    private static final String CHARACTERS_NAME = "/characters/{name}";
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService){
        this.characterService = characterService;
    }

    @GetMapping(CHARACTERS)
    public List<CharacterDTO> getCharacters(
            @RequestParam(name="name",required = false) String name,
            @RequestParam(name="age",required = false) Integer age,
            @RequestParam(name="movie",required = false) String movie){
        List<CharacterDTO> charactersDTO;

       if(name!=null){
            charactersDTO = characterService.listAllByName(name);
        }else if(age!=null){
            charactersDTO = characterService.listAllByAge(age);
        }else if (movie!=null){
            charactersDTO = characterService.listAllByMovie(movie);
        }else {
            charactersDTO = characterService.listAll();
        }
        return charactersDTO;//devuelve la lista de personajes
    }

    @GetMapping(CHARACTERS_DETAIL)
    public List<CharacterDetailDTO> detailsCharacters(){
        return characterService.characterDetailsList();
    }

    @PostMapping(CHARACTERS)
    public  Character saveCharacter(@RequestBody Character character){
        return this.characterService.save(character);
    }

    @DeleteMapping(CHARACTERS_NAME)
    public ResponseEntity<?> deleteCharacter(@PathVariable(name = "name") String nameCharacter){
         this.characterService.delete(nameCharacter);
        return new ResponseEntity<>("personaje eliminado exitosamente", HttpStatus.OK);
    }

    @PutMapping(CHARACTERS)
    public Character updateCharacter(@RequestBody Character character){
         return this.characterService.save(character);
    }

}
