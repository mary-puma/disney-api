package org.isamary.repository;

import org.isamary.entity.Genre;
import org.isamary.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT c FROM Movie c JOIN c.genres g WHERE g.name=?1")
    List<Movie> findMovieByGenre(String genre);

    @Query("SELECT c FROM Movie c WHERE c.title=?1")
    List<Movie> findMovieByTitle(String title);

    @Query("SELECT m FROM Movie m ORDER BY m.creation_date DESC")
    List<Movie> orderByCreationDateDesc();

    @Query("SELECT m FROM Movie m ORDER BY m.creation_date ASC")
    List<Movie> orderByCreationDateAsc();





}
