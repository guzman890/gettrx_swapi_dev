package com.gettrx.swapi.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PeopleDTO {
    private Integer id;
    private String name;
    private String birth_year;
    private String eye_color;
    private String gender;
    private String hair_color;
    private String height;
    private String homeworld;
    private String mass;
    private String skin_color;
    private String created;
    private String edited;
    private String url;
}
