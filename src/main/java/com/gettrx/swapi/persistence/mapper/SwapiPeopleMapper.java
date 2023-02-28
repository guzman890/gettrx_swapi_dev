package com.gettrx.swapi.persistence.mapper;

import com.gettrx.swapi.domain.dto.PeopleDTO;
import com.gettrx.swapi.external.dto.SwapiPeopleDTO;
import com.gettrx.swapi.persistence.entity.People;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SwapiPeopleMapper {
    SwapiPeopleMapper INSTANCE = Mappers.getMapper(SwapiPeopleMapper.class);
    @Mapping(source = "url", target = "id", qualifiedByName = "urlToId")

    PeopleDTO toSwapiPeopleDTO(SwapiPeopleDTO people);
    List<PeopleDTO> toSwapiPeopleDTOList(List<SwapiPeopleDTO> people);

    @Named("urlToId")
    public static String urlToId(String url) {
        return url.replace("https://swapi.dev/api/people","")
                .replace("/","");
    }
}
