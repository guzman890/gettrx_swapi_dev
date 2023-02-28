package com.gettrx.swapi.web.controller;

import com.gettrx.swapi.domain.dto.PeopleDTO;
import com.gettrx.swapi.domain.service.PeopleService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<PeopleDTO> getByPage(@PathVariable("idPage") int idPage){
        return peopleService.getPeopleByPage(idPage);
    }

    @GetMapping("/{idPeople}")
    public PeopleDTO getPeople(@PathVariable("idPeople") int idPeople){
        return peopleService.getPeople(idPeople);
    }

    @PostMapping("/save")
    public PeopleDTO save(@RequestBody PeopleDTO peopleDTO){
        return peopleService.save(peopleDTO);
    }

    @DeleteMapping("/delete/{idPeople}")
    public boolean delete( @PathVariable("idPeople") int idPeople){
        return peopleService.delete(idPeople);
    }
}
