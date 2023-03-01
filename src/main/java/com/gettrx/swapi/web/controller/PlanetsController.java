package com.gettrx.swapi.web.controller;

import com.gettrx.swapi.domain.dto.PlanetsDTO;
import com.gettrx.swapi.domain.service.PlanetsService;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> getByPage(@PathVariable("idPage") int idPage){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.OK);
        body.put("response", planetsService.getPlanetsByPage(idPage));
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping("/{idPlanets}")
    public ResponseEntity<Object> getPlanets(@PathVariable("idPlanets") int idPlanets){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.OK);
        body.put("response", planetsService.getPlanets(idPlanets));
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody PlanetsDTO peopleDTO){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.OK);
        body.put("response", planetsService.save(peopleDTO));
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idPlanets}")
    public ResponseEntity<Object> delete( @PathVariable("idPlanets") int idPlanets){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.OK);
        body.put("response", planetsService.delete(idPlanets));
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
