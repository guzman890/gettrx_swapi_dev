package com.gettrx.swapi.persistence.mapper;

import com.gettrx.swapi.domain.dto.PeopleDTO;
import com.gettrx.swapi.persistence.entity.People;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PeopleMapper {
    PeopleMapper INSTANCE = Mappers.getMapper(PeopleMapper.class);

    PeopleDTO toPeopleDTO(People people);
    List<PeopleDTO> toPeopleDTOList(List<People> people);
    @InheritInverseConfiguration
    People toPeople(PeopleDTO peopleDto);

}
