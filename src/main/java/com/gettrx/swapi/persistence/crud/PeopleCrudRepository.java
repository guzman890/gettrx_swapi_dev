package com.gettrx.swapi.persistence.crud;

import com.gettrx.swapi.persistence.entity.People;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PeopleCrudRepository extends CrudRepository<People,Integer> {
    List<People> findAll();
}
