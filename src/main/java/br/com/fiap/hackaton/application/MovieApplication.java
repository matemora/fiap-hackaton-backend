package br.com.fiap.hackaton.application;


import br.com.fiap.hackaton.dto.MovieDto;

import java.util.List;

public interface MovieApplication {
    List<MovieDto> searchMovies(String term);
    MovieDto getMovie(Long id);
}
