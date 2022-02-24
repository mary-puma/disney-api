package org.isamary.service;

import org.isamary.dto.CharacterDTO;
import org.isamary.dto.CharacterDetailDTO;
import org.isamary.entity.Character;
import org.isamary.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public List<CharacterDTO> listAllByName(String name) {
        return charactersListToCharactersDTO(characterRepository.findCharacterByName(name));
    }

    public List<CharacterDTO> listAllByAge(int age) {
        return charactersListToCharactersDTO(characterRepository.findCharacterByAge(age));
    }

    public List<CharacterDTO> listAllByMovie(String movie) {
        return charactersListToCharactersDTO(characterRepository.findCharacterByMovie(movie));
    }

    public List<CharacterDTO> listAll() {
        return charactersListToCharactersDTO(characterRepository.findAll());
    }

    public Character save(Character character){
        return characterRepository.save(character);
    }

    public void delete(Character character) {
        characterRepository.delete(character);
    }

    public List<CharacterDTO> charactersListToCharactersDTO(List<Character> characterList){
        return characterList
                .stream()
                .map(Character::convertCharacterToCharacterDTO)
                .collect(Collectors.toList());
    }

    public List<CharacterDetailDTO> characterListToCharacterDetailsDTO(List<Character> characterList){
        return characterList
                .stream()
                .map(Character::convertCharacterToCharacterDetailDTO)
                .collect(Collectors.toList());
    }//es similar a un for each lo que hacemos aca es pasar de la lista personajes los campos que queremos a la lista personajes dto

    public List<CharacterDetailDTO> characterDetailsList() {
        return characterListToCharacterDetailsDTO(characterRepository.findAll());
    }

}
