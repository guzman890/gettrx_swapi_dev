package com.gettrx.swapi.domain.repository.impl;

import com.gettrx.swapi.domain.dto.PeopleDTO;
import com.gettrx.swapi.domain.dto.PlanetsDTO;
import com.gettrx.swapi.domain.repository.PeopleRepository;
import com.gettrx.swapi.persistence.crud.PeopleCrudRepository;
import com.gettrx.swapi.persistence.entity.People;
import com.gettrx.swapi.persistence.entity.Planets;
import com.gettrx.swapi.persistence.mapper.PeopleMapper;
import com.gettrx.swapi.persistence.mapper.PlanetsMapper;
import com.gettrx.swapi.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PeopleRepositoryImpl implements PeopleRepository {

    @Autowired
    private PeopleCrudRepository peopleCrudRepository;
    @Override
    public Optional<List<PeopleDTO>> getAll() {
        return Optional.ofNullable(PeopleMapper.INSTANCE.toPeopleDTOList(peopleCrudRepository.findAll()));
    }

    @Override
    public Optional<PeopleDTO> getPeople(int id) {
        Optional<People> people = peopleCrudRepository.findById(id);
        return people.map(PeopleMapper.INSTANCE::toPeopleDTO);
    }

    @Override
    public PeopleDTO save(PeopleDTO peopleDTO) {
        People people = PeopleMapper.INSTANCE.toPeople(peopleDTO);
        people = peopleCrudRepository.save(people);
        return PeopleMapper.INSTANCE.toPeopleDTO(people);
    }

    @Override
    public void delete(int id) {
        peopleCrudRepository.deleteById(id);
    }
}
