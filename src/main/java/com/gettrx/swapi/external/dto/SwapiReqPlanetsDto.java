package com.gettrx.swapi.external.dto;

import com.gettrx.swapi.domain.dto.PlanetsDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SwapiReqPlanetsDto {
    private Integer count;
    private String next;
    private String previous;
    private SwapiPlanetsDTO[] results;
}
