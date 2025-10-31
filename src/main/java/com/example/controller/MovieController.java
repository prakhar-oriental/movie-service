package com.example.controller;

import com.example.model.Movie;
import com.example.model.Show;
import com.example.model.TheaterDTO;
import com.example.service.MovieService;
import com.example.service.ShowService;
import com.example.service.TheaterClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final TheaterClient theaterClient;

    private final MovieService movieService;
    @Autowired
    private  ShowService showService;

    public MovieController(MovieService movieService,TheaterClient theaterClient) {
        this.movieService = movieService;
        this.theaterClient = theaterClient;
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

    @GetMapping("/shows/{id}/details")
    public ResponseEntity<?> getShowWithTheater(@PathVariable Long id) {
        Show show = showService.getShowById(id);
        TheaterDTO theater = theaterClient.getTheaterById(show.getTheaterId());

        Map<String, Object> response = new HashMap<>();
        response.put("show", show);
        response.put("theater", theater);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getshowbyid/{id}")
    public ResponseEntity<Show> getshowbyid(@PathVariable("id") long id){
        Show show = showService.getShowById(id);
        return ResponseEntity.ok(show);
    }

}
