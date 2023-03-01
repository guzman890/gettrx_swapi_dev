package com.gettrx.swapi.domain.service.impl;

import com.gettrx.swapi.domain.dto.PeopleDTO;
import com.gettrx.swapi.domain.dto.PlanetsDTO;
import com.gettrx.swapi.domain.repository.PlanetsRepository;
import com.gettrx.swapi.domain.service.PlanetsService;
import com.gettrx.swapi.exception.PageNotFoundException;
import com.gettrx.swapi.exception.PlanetsNotFoundException;
import com.gettrx.swapi.exception.ValidateException;
import com.gettrx.swapi.external.SwapiWebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.gettrx.swapi.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlanetsServiceImpl implements PlanetsService {
    private static Integer idGenerator = 10000;
    @Autowired
    private PlanetsRepository planetsRepository;
    @Autowired
    private SwapiWebClient swapiWebClient;
    @Override
    public List<PlanetsDTO> getAll(){
        return planetsRepository.getAll().orElse(null);
    }
    @Override
    public List<PlanetsDTO> getPlanetsByPage(int idPage) {

        List<PlanetsDTO> listPlanetsDTO = new ArrayList<>();
        for (int page = 1; page<=idPage; page++) {
            swapiWebClient.getPlanetsByPage(page)
                    .map(listPlanetsDTO::addAll)
                    .orElseThrow(() -> new PageNotFoundException("Planets", idPage));
        }

        return listPlanetsDTO;
    }
    @Override
    public PlanetsDTO getPlanets(int idPlanets){
        return swapiWebClient.getPlanets(idPlanets)
                .map(planets -> planetsRepository.save(planets))
                .orElseThrow(()->new PlanetsNotFoundException(idPlanets));
    }
    @Override
    public PlanetsDTO save(PlanetsDTO planetsReq) {
        setIdIfNull(planetsReq);
        if(Util.validatePlanets(planetsReq))
            return planetsRepository.save(planetsReq);
        else
            throw new ValidateException("Planets");
    }
    @Override
    public boolean delete(int idPlanets){
        return planetsRepository.getPlanets(idPlanets).map(planets -> {
            planetsRepository.delete(idPlanets);
            return true;
        }).orElseThrow(()->new PlanetsNotFoundException(idPlanets));
    }

    private void setIdIfNull(PlanetsDTO planetsReq){
        if(Objects.isNull(planetsReq.getId())){
            planetsReq.setId(idGenerator.intValue());
            idGenerator++;
        }
    }
}
