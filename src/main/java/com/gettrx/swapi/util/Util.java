package com.gettrx.swapi.util;

import com.gettrx.swapi.domain.dto.PeopleDTO;
import com.gettrx.swapi.domain.dto.PlanetsDTO;

import java.util.Objects;

public class Util {
    public static boolean validatePeople(PeopleDTO source){
        return Objects.nonNull(source.getId()) &&
        Objects.nonNull(source.getName()) &&
        Objects.nonNull(source.getBirth_year()) &&
        Objects.nonNull(source.getEye_color()) &&
        Objects.nonNull(source.getGender()) &&
        Objects.nonNull(source.getHair_color()) &&
        Objects.nonNull(source.getHeight()) &&
        Objects.nonNull(source.getHomeworld()) &&
        Objects.nonNull(source.getMass()) &&
        Objects.nonNull(source.getSkin_color()) &&
        Objects.nonNull(source.getCreated()) &&
        Objects.nonNull(source.getEdited()) &&
        Objects.nonNull(source.getUrl());
    }
    public static boolean validatePlanets(PlanetsDTO source){
        return Objects.nonNull(source.getId()) &&
        Objects.nonNull(source.getName()) &&
        Objects.nonNull(source.getPopulation()) &&
        Objects.nonNull(source.getResidents()) &&
        Objects.nonNull(source.getTerrain()) &&
        Objects.nonNull(source.getUrl());
    }

}
