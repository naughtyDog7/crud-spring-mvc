package org.example.services;

import org.example.dao.MovieDAO;
import org.example.dao.MovieDAOImpl;
import org.example.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieDAO movieDAO;

    @Autowired
    public MovieServiceImpl(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

    @Override
    public List<Movie> allMovies(){
        return movieDAO.allMovies();
    }

    @Override
    public void add(Movie movie) {
        movieDAO.add(movie);
    }

    @Override
    public void delete(Movie movie){
        movieDAO.delete(movie);
    }

    @Override
    public void update(Movie movie) {
        movieDAO.update(movie);
    }

    @Override
    public Movie getById(int id) {
        return movieDAO.getById(id);
    }
}
