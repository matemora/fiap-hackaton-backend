package br.com.fiap.hackaton.controller;

import br.com.fiap.hackaton.application.MovieApplication;
import br.com.fiap.hackaton.dto.MovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    private final MovieApplication movieApplication;

    public MoviesController(@Autowired MovieApplication movieApplication) {
        this.movieApplication = movieApplication;
    }


    @GetMapping
    public ResponseEntity<List<MovieDto>> searchMovie (@RequestParam(required = false) String searchTerm) {
        return ResponseEntity.ok(this.movieApplication.searchMovies(searchTerm));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovie (@PathVariable Long id) {
        return ResponseEntity.ok(this.movieApplication.getMovie(id));
    }


}
