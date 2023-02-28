package com.gettrx.swapi.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class PlanetsDTO {
    private Integer id;
    private String climate;
    private String diameter;
    private String gravity;
    private String name;
    private String population;
    private String residents;
    private String terrain;
    private String url;
}
