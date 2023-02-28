package com.gettrx.swapi.external.dto;

import com.gettrx.swapi.domain.dto.PeopleDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SwapiReqPeopleDto {
    private Integer count;
    private String next;
    private String previous;
    private SwapiPeopleDTO[] results;
}
