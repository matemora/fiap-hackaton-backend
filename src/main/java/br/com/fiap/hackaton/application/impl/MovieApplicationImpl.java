package br.com.fiap.hackaton.application.impl;

import br.com.fiap.hackaton.application.MovieApplication;
import br.com.fiap.hackaton.dto.MovieDto;
import br.com.fiap.hackaton.model.Movie;
import br.com.fiap.hackaton.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieApplicationImpl implements MovieApplication {

    private final MovieService movieService;

    public MovieApplicationImpl(@Autowired MovieService movieService){
        this.movieService = movieService;
    }

    @Override
    public List<MovieDto> searchMovies(String term) {
        return this.movieService.findMovie(term).stream().map(movie -> new MovieDto(movie.getId(),
                movie.getTitle(),
                movie.getDescription(),
                movie.getCategory(),
                movie.getCoverUri(),
                movie.getVideoUri(),
                movie.getReleaseDate())).collect(Collectors.toList());
    }

    @Override
    public MovieDto getMovie(Long id){
        Movie movie = this.movieService.getMovie(id);
        return new MovieDto(movie.getId(),
                movie.getTitle(),
                movie.getDescription(),
                movie.getCategory(),
                movie.getCoverUri(),
                movie.getVideoUri(),
                movie.getReleaseDate());
    }

}
