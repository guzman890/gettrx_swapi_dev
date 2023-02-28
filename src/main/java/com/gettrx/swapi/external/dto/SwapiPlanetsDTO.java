package com.gettrx.swapi.external.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SwapiPlanetsDTO {
    private Integer id;
    private String climate;
    private String diameter;
    private String gravity;
    private String name;
    private String population;
    private List<String> residents;
    private String terrain;
    private String url;
}
