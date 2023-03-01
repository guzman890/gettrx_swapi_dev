package com.gettrx.swapi.persistence.mapper;

import com.gettrx.swapi.domain.dto.PlanetsDTO;
import com.gettrx.swapi.external.dto.SwapiPlanetsDTO;
import com.gettrx.swapi.persistence.entity.Planets;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SwapiPlanetsMapper {
    SwapiPlanetsMapper INSTANCE = Mappers.getMapper(SwapiPlanetsMapper.class);
    @Mapping(source = "residents", target = "residents", qualifiedByName = "residentsFunction")
    @Mapping(source = "url", target = "id", qualifiedByName = "urlToId")

    PlanetsDTO toPlanetsDTO(SwapiPlanetsDTO planets);
    List<PlanetsDTO> toPlanetsDTOList(List<SwapiPlanetsDTO> planetsList);
    @Named("residentsFunction")
    public static String residentsFunction(List<String> residents) {
        return residents.isEmpty()? "":residents.get(0);
    }

    @Named("urlToId")
    public static String urlToId(String url) {
        return url.replace("https://swapi.dev/api/planets","")
                .replace("/","");
    }
}
