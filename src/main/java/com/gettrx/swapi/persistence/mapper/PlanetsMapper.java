package com.gettrx.swapi.persistence.mapper;

import com.gettrx.swapi.domain.dto.PlanetsDTO;
import com.gettrx.swapi.persistence.entity.Planets;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PlanetsMapper {
    PlanetsMapper INSTANCE = Mappers.getMapper(PlanetsMapper.class);

    PlanetsDTO toPlanetsDTO(Planets planets);
    List<PlanetsDTO> toPlanetsDTOList(List<Planets> planetsList);
    @InheritInverseConfiguration
    Planets toPlanets(PlanetsDTO planets);

}
