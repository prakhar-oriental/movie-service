package com.example.service;


import com.example.model.Movie;
import com.example.model.Show;
import com.example.repository.MovieRepository;
import com.example.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final ShowRepository showRepository;

    public MovieService(MovieRepository movieRepository, ShowRepository showRepository) {
        this.movieRepository = movieRepository;
        this.showRepository = showRepository;
    }

    // Movie methods
    public List<Movie> getAllMovies() { return movieRepository.findAll(); }
    public Movie getMovie(Long id) { return movieRepository.findById(id).orElse(null); }
    public Movie addMovie(Movie movie) { return movieRepository.save(movie); }

    // Show methods
    public List<Show> getShowsByMovie(Long movieId) { return showRepository.findByMovieId(movieId); }
    public Show addShow(Show show) { return showRepository.save(show); }
}
