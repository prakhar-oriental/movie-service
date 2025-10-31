package com.example.service;

import com.example.model.Show;

import java.util.List;

public interface ShowService {
    Show saveShow(Show show);
    Show getShowById(Long id);
    List<Show> getAllShows();
}
