package com.gettrx.swapi.web.controller;

import com.gettrx.swapi.domain.dto.PeopleDTO;
import com.gettrx.swapi.domain.service.PeopleService;

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
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping("/")
    public List<PeopleDTO> getAll(){
        return peopleService.getAll();
    }

    @GetMapping("/page/{idPage}")
    public ResponseEntity<Object> getByPage(@PathVariable("idPage") int idPage){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.OK);
        body.put("response", peopleService.getPeopleByPage(idPage));
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping("/{idPeople}")
    public ResponseEntity<Object> getPeople(@PathVariable("idPeople") int idPeople){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.OK);
        body.put("response", peopleService.getPeople(idPeople));
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody PeopleDTO peopleDTO){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.OK);
        body.put("response", peopleService.save(peopleDTO));
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idPeople}")
    public ResponseEntity<Object> delete( @PathVariable("idPeople") int idPeople){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.OK);
        body.put("response", peopleService.delete(idPeople));
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
