package br.com.fiap.hackaton.service.impl;

import br.com.fiap.hackaton.exception.MovieNotFoundException;
import br.com.fiap.hackaton.model.Movie;
import br.com.fiap.hackaton.repository.MovieRepository;
import br.com.fiap.hackaton.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(@Autowired MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findMovie(String query) {
        List<Movie> list = this.movieRepository.findMoviesByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(query, query);

        if (list.isEmpty()){

            throw new MovieNotFoundException("Nenhum Treinamento encontrado",
                    new StringBuilder("Não foi possível encontrar treinamento com ").append(query).toString());
        }
        return list;

    }

    @Override
    public Movie getMovie(Long id) {
        return this.movieRepository.findById(id).orElseThrow(() -> {
            throw new MovieNotFoundException("Treinamento não encontrado",
                    new StringBuilder("Não foi possível encontrar o treinamento ID: ").append(id).toString());
        });
    }
}
