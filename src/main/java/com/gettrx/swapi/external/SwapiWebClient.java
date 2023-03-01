package com.gettrx.swapi.external;

import com.gettrx.swapi.domain.dto.PeopleDTO;
import com.gettrx.swapi.domain.dto.PlanetsDTO;
import com.gettrx.swapi.exception.PageNotFoundException;
import com.gettrx.swapi.exception.PeopleNotFoundException;
import com.gettrx.swapi.exception.PlanetsNotFoundException;
import com.gettrx.swapi.external.dto.SwapiPeopleDTO;
import com.gettrx.swapi.external.dto.SwapiPlanetsDTO;
import com.gettrx.swapi.external.dto.SwapiReqPeopleDto;
import com.gettrx.swapi.external.dto.SwapiReqPlanetsDto;
import com.gettrx.swapi.persistence.mapper.PeopleMapper;
import com.gettrx.swapi.persistence.mapper.SwapiPeopleMapper;
import com.gettrx.swapi.persistence.mapper.SwapiPlanetsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.*;
@Slf4j
@Service
public class SwapiWebClient {
    private final WebClient webClient;

    public SwapiWebClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://swapi.dev/api").build();
    }
    public Optional<List<PeopleDTO>> getPeopleByPage(Integer idPage){
        try {
        SwapiPeopleDTO[] aPeopleDTO = Objects.requireNonNull(webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/people/")
                        .queryParam("page", idPage)
                        .build())
                .retrieve()
                .bodyToMono(SwapiReqPeopleDto.class)
                .onErrorResume(Mono::error)
                .block())
                .getResults();
            return Optional.ofNullable(SwapiPeopleMapper.INSTANCE.toSwapiPeopleDTOList(Arrays.asList(aPeopleDTO)));
        } catch(Exception exception) {
            log.error(exception.getMessage());
            return Optional.empty();
        }
    }
    public Optional<PeopleDTO> getPeople(Integer id){
        try {
            SwapiPeopleDTO  swapiPeopleDTO = webClient.get()
                .uri("/people/{id}", id)
                .retrieve()
                .bodyToMono(SwapiPeopleDTO.class)
                .onErrorResume(Mono::error)
                .block();
            return Optional.ofNullable(SwapiPeopleMapper.INSTANCE.toSwapiPeopleDTO(swapiPeopleDTO));
        } catch(Exception exception) {
            log.error(exception.getMessage());
            return Optional.empty();
        }
    }
    public Optional<List<PlanetsDTO>> getPlanetsByPage(Integer idPage){
        try {
            SwapiPlanetsDTO[] aPlanetsDTO =  Objects.requireNonNull(webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/planets/")
                        .queryParam("page", idPage)
                        .build())
                .retrieve()
                .bodyToMono(SwapiReqPlanetsDto.class)
                .onErrorResume(Mono::error)
                .block())
                .getResults();

            return Optional.ofNullable(SwapiPlanetsMapper.INSTANCE.toPlanetsDTOList(Arrays.asList(aPlanetsDTO)));
        } catch(Exception exception) {
            log.error(exception.getMessage());
            return Optional.empty();
        }
    }
    public Optional<PlanetsDTO> getPlanets(Integer id){
        try {
            SwapiPlanetsDTO aPlanetsDTO = webClient.get()
                .uri("/planets/{id}", id)
                .retrieve()
                .bodyToMono(SwapiPlanetsDTO.class)
                .onErrorResume(Mono::error)
                .block();
            return Optional.ofNullable(SwapiPlanetsMapper.INSTANCE.toPlanetsDTO(aPlanetsDTO));
        } catch(Exception exception) {
            log.error(exception.getMessage());
            return Optional.empty();
        }
    }
}
