package com.example.movie_service.controller;

import com.example.movie_service.model.Movie;
import com.example.movie_service.model.Show;
import com.example.movie_service.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAllMovies() { return movieService.getAllMovies(); }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable Long id) { return movieService.getMovie(id); }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) { return movieService.addMovie(movie); }

    @GetMapping("/{id}/shows")
    public List<Show> getShows(@PathVariable Long id) { return movieService.getShowsByMovie(id); }

    @PostMapping("/shows")
    public Show addShow(@RequestBody Show show) { return movieService.addShow(show); }
}
