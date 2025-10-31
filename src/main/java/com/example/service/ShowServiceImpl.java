package com.example.service;

import com.example.model.Movie;
import com.example.model.Show;
import com.example.repository.MovieRepository;
import com.example.repository.ShowRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
@Service
public class ShowServiceImpl implements ShowService {
    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;
    private Logger log;

    public ShowServiceImpl(ShowRepository showRepository,
                           MovieRepository movieRepository) {
        this.showRepository = showRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public Show saveShow(Show show) {
        return showRepository.save(show);
    }

    @Override
    public Show getShowById(Long id) {
        return showRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Show not found with id: " + id));
    }

    @Override
    public List<Show> getAllShows() {
        return showRepository.findAll();
    }
}
