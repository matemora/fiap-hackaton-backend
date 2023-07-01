package br.com.fiap.hackaton.service;

import br.com.fiap.hackaton.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findMovie(String query);
    Movie getMovie(Long id);
}
