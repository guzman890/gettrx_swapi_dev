package com.gettrx.swapi.persistence.crud;

import com.gettrx.swapi.persistence.entity.Planets;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlanetsCrudRepository extends CrudRepository<Planets,Integer> {
    List<Planets> findAll();
}
