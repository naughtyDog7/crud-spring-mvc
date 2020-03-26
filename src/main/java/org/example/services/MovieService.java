package org.example.services;

import org.example.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> allMovies();
    void add(Movie movie);
    void delete(Movie movie);
    void update(Movie movie);
    Movie getById(int id);
}
