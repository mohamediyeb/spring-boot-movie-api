package com.film.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.film.model.Acteur;
import com.film.repository.ActeurEntity;

@Mapper
public interface ActeurMapper {
    public static ActeurMapper INSTANCE = Mappers.getMapper(ActeurMapper.class);


    ActeurEntity mapTo(Acteur acteur);
    @InheritInverseConfiguration
    Acteur mapTo(ActeurEntity acteurEntity);
}
