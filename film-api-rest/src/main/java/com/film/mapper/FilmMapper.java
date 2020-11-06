package com.film.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.film.model.Film;
import com.film.repository.FilmEntity;

@Mapper(uses = ActeurMapper.class)
public interface FilmMapper {
    public static FilmMapper INSTANCE = Mappers.getMapper(FilmMapper.class);


    FilmEntity mapTo(Film movie);
    @InheritInverseConfiguration
    Film mapTo(FilmEntity movieEntity);
}

