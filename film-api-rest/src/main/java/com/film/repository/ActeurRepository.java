package com.film.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActeurRepository extends CrudRepository<ActeurEntity, Long> {
}
