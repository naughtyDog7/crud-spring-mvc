package org.example.dao;

import org.example.model.Movie;

import java.util.List;

public interface MovieDAO {
    List<Movie> allMovies();
    void add(Movie movie);
    void delete(Movie movie);
    void update(Movie movie);
    Movie getById(int id);
}
