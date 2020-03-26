package org.example.controller;

import org.dom4j.rule.Mode;
import org.example.model.Movie;
import org.example.services.MovieService;
import org.example.services.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.List;

@Controller
public class MovieController {
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(value = "/delete{id}")
    public ModelAndView deleteMovie(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        movieService.delete(movieService.getById(id));
        return modelAndView;
    }

    @GetMapping(value = "/")
    public ModelAndView allFilms() {
        List<Movie> movieList = movieService.allMovies();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("movieList", movieList);
        return modelAndView;
    }

    @RequestMapping(value = "/edit{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        Movie movie = movieService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.getView();
        modelAndView.addObject("movie", movie);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editMovie(@ModelAttribute("movie") Movie movie) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        movieService.update(movie);
        return modelAndView;
    }

    @GetMapping(value = "/add")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView addMovie(@ModelAttribute("movie") Movie movie) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        movieService.add(movie);
        return modelAndView;
    }
}
