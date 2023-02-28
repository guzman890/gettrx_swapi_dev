package com.gettrx.swapi.domain.service;

import com.gettrx.swapi.domain.dto.PeopleDTO;

import java.util.List;
import java.util.Optional;

public interface PeopleService {
    List<PeopleDTO> getAll();
    List<PeopleDTO> getPeopleByPage(int idPage);
    PeopleDTO getPeople(int idPeople);
    PeopleDTO save(PeopleDTO people);
    boolean delete(int idPeople);
}
