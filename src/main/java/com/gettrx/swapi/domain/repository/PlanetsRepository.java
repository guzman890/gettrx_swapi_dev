package com.gettrx.swapi.domain.repository;

import com.gettrx.swapi.domain.dto.PlanetsDTO;

import java.util.List;
import java.util.Optional;

public interface PlanetsRepository {
    Optional<List<PlanetsDTO>> getAll();
    Optional<PlanetsDTO> getPlanets(int id);
    PlanetsDTO save(PlanetsDTO people);
    void  delete(int id);
}
