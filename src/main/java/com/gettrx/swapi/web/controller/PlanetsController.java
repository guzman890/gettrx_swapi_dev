package com.gettrx.swapi.web.controller;

import com.gettrx.swapi.domain.dto.PlanetsDTO;
import com.gettrx.swapi.domain.service.PlanetsService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/planets")
public class PlanetsController {
    @Autowired
    private PlanetsService planetsService;

    @GetMapping("/")
    public List<PlanetsDTO> getAll(){
        return planetsService.getAll();
    }

    @GetMapping("/page/{idPage}")
    public List<PlanetsDTO> getByPage(@PathVariable("idPage") int idPage){
        return planetsService.getPlanetsByPage(idPage);
    }

    @GetMapping("/{idPlanets}")
    public PlanetsDTO getPlanets(@PathVariable("idPlanets") int idPlanets){
        return planetsService.getPlanets(idPlanets);
    }

    @PostMapping("/save")
    public PlanetsDTO save(@RequestBody PlanetsDTO peopleDTO){
        return planetsService.save(peopleDTO);
    }

    @DeleteMapping("/delete/{idPlanets}")
    public boolean delete( @PathVariable("idPlanets") int idPlanets){
        return planetsService.delete(idPlanets);
    }
}
