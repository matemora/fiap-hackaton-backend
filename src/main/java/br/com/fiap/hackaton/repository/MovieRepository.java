package br.com.fiap.hackaton.repository;

import br.com.fiap.hackaton.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    List<Movie> findMoviesByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String title, String description);
}
