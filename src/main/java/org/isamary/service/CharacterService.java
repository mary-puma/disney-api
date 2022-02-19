package org.isamary.service;

import org.isamary.entity.Character;
import org.isamary.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;


    public List<Character> listAllByName(String name) {
        return characterRepository.findCharacterByName(name);
    }
    public List<Character> listAllByAge(int age) {
        return characterRepository.findCharacterByAge(age);
    }
    public List<Character> listAllByMovie(String movie) {
        return characterRepository.findCharacterByMovie(movie);
    }
    public List<Character> listAll() {
        return characterRepository.findAll();
    }


    public Character save(Character character){
        return characterRepository.save(character);
    }
    public void delete(Character character) {
        characterRepository.delete(character);
    }
}
