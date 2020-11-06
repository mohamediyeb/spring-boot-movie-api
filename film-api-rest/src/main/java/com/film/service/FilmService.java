package com.film.service;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.film.mapper.ActeurMapper;
import com.film.mapper.FilmMapper;
import com.film.model.Film;
import com.film.repository.ActeurEntity;
import com.film.repository.ActeurRepository;
import com.film.repository.FilmEntity;
import com.film.repository.FilmRepository;

@Service
public class FilmService {
	private FilmRepository filmRepository;
	private ActeurRepository acteurRepository;

	@Autowired
	public FilmService(FilmRepository movieRepository, ActeurRepository actorRepository) {
		super();
		this.filmRepository = movieRepository;
		this.acteurRepository = actorRepository;
	}

	@Transactional
	public ResponseEntity<Film> addFilm(Film film) {
		FilmEntity movieEntity = FilmMapper.INSTANCE.mapTo(film);

		FilmEntity savedFilm = filmRepository.save(movieEntity);
		film.getActeurs().forEach(x -> {
			ActeurEntity acteurEntity = ActeurMapper.INSTANCE.mapTo(x);
			acteurEntity.setFilm(savedFilm);
			acteurRepository.save(acteurEntity);

		});

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedFilm.getId())
				.toUri();
		Film movie = FilmMapper.INSTANCE.mapTo(savedFilm);
		return ResponseEntity.created(location).body(movie);
	}

	public ResponseEntity<Film> getFilmById(Long id) {
		Optional<FilmEntity> movieEntity = filmRepository.findById(id);
		Film movie = FilmMapper.INSTANCE.mapTo(movieEntity.get());
		return ResponseEntity.ok(movie);
	}

}
