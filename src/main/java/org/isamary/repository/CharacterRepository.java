package org.isamary.repository;

import org.isamary.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
//capa que se comunica directamente con  la bbdd
@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

    @Query("SELECT c FROM Character c JOIN c.movies m WHERE m.title=?1")
    List<Character> findCharacterByMovie(String movie);


    @Query("SELECT c FROM Character c WHERE c.name=?1")
    List<Character> findCharacterByName(String name);

    @Query("SELECT c FROM Character c WHERE c.age=?1")
    List<Character> findCharacterByAge(int age);


}
