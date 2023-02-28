package com.gettrx.swapi.domain.service;

import com.gettrx.swapi.domain.dto.PlanetsDTO;

import java.util.List;
import java.util.Optional;

public interface PlanetsService {
    List<PlanetsDTO> getAll();
    List<PlanetsDTO> getPlanetsByPage(int idPage);
    PlanetsDTO getPlanets(int idPlanets);
    PlanetsDTO save(PlanetsDTO planets);
    boolean delete(int idPlanets);
}
