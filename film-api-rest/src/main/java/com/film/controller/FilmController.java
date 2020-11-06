package com.film.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.film.api.FilmsApi;
import com.film.model.Film;
import com.film.service.FilmService;
@RestController
public class FilmController implements FilmsApi {
   
    private FilmService filmService; 
    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }



    @Override
    public ResponseEntity<Film> createFilm(@Valid Film film) {
        return filmService.addFilm(film);
    }

    @Override
    public ResponseEntity<Film> getFilmById(Long id) {
        return filmService.getFilmById(id);
    }
}
