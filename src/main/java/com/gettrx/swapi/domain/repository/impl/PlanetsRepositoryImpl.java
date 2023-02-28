package com.gettrx.swapi.domain.repository.impl;

import com.gettrx.swapi.domain.dto.PlanetsDTO;
import com.gettrx.swapi.domain.repository.PlanetsRepository;
import com.gettrx.swapi.persistence.crud.PlanetsCrudRepository;
import com.gettrx.swapi.persistence.entity.Planets;
import com.gettrx.swapi.persistence.mapper.PlanetsMapper;
import java.util.List;
import java.util.Optional;

import com.gettrx.swapi.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class PlanetsRepositoryImpl implements PlanetsRepository {
    @Autowired
    private PlanetsCrudRepository planetsCrudRepository;

    @Override
    public Optional<List<PlanetsDTO>> getAll() {
        return Optional.ofNullable(PlanetsMapper.INSTANCE.toPlanetsDTOList(planetsCrudRepository.findAll()));
    }

    @Override
    public Optional<PlanetsDTO> getPlanets(int id) {
        Optional<Planets> planets = planetsCrudRepository.findById(id);
        return planets.map(PlanetsMapper.INSTANCE::toPlanetsDTO);
    }

    @Override
    public PlanetsDTO save(PlanetsDTO planetsDTO) {
        Planets planets = PlanetsMapper.INSTANCE.toPlanets(planetsDTO);
        planets = planetsCrudRepository.save(planets);
        return PlanetsMapper.INSTANCE.toPlanetsDTO(planets);
    }

    @Override
    public void delete(int id) {
        planetsCrudRepository.deleteById(id);
    }
}
