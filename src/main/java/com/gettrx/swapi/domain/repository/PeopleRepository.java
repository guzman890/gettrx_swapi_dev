package com.gettrx.swapi.domain.repository;

import com.gettrx.swapi.domain.dto.PeopleDTO;
import java.util.List;
import java.util.Optional;

public interface PeopleRepository {
    Optional<List<PeopleDTO>> getAll();
    Optional<PeopleDTO> getPeople(int id);
    PeopleDTO save(PeopleDTO people);
    void  delete(int id);
}
