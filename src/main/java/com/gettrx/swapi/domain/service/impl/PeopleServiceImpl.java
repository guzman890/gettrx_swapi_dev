package com.gettrx.swapi.domain.service.impl;

import com.gettrx.swapi.domain.dto.PeopleDTO;
import com.gettrx.swapi.domain.repository.PeopleRepository;
import com.gettrx.swapi.domain.service.PeopleService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.gettrx.swapi.exception.PageNotFoundException;
import com.gettrx.swapi.exception.PeopleNotFoundException;
import com.gettrx.swapi.exception.ValidateException;
import com.gettrx.swapi.external.SwapiWebClient;
import com.gettrx.swapi.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PeopleServiceImpl implements PeopleService {
    private static Integer idGenerator = 10000;
    @Autowired
    private PeopleRepository peopleRepository;
    @Autowired
    private SwapiWebClient swapiWebClient;
    @Override
    public List<PeopleDTO> getAll(){
        return peopleRepository.getAll().orElse(null);
    }
    @Override
    public List<PeopleDTO> getPeopleByPage(int idPage) {

        int currentPage = idPage;
        for (int page = 1; page<currentPage; page++) {
            swapiWebClient.getPeopleByPage(page).map( listPeople->{
                listPeople.forEach(peopleDTO -> peopleRepository.save(peopleDTO));
                return listPeople;
            }).orElseThrow(() -> new PageNotFoundException("People", idPage));
        }

        return swapiWebClient.getPeopleByPage(idPage).map( listPeople->{
            listPeople.forEach(peopleDTO -> peopleRepository.save(peopleDTO));
            return listPeople;
        }).orElseThrow(() -> new PageNotFoundException("People", idPage));
    }
    @Override
    public PeopleDTO getPeople(int idPeople){
        return swapiWebClient.getPeople(idPeople)
                .map(people-> peopleRepository.save(people))
                .orElseThrow(()->new PeopleNotFoundException(idPeople));
    }
    @Override
    public PeopleDTO save(PeopleDTO peopleReq){
        setIdIfNull(peopleReq);
        if(Util.validatePeople(peopleReq))
            return peopleRepository.save(peopleReq);
        else
            throw new ValidateException("People");
    }
    @Override
    public boolean delete(int idPeople){
        return peopleRepository.getPeople(idPeople).map(people -> {
            peopleRepository.delete(idPeople);
            return true;
        }).orElseThrow(()->new PeopleNotFoundException(idPeople));
    }

    private void setIdIfNull(PeopleDTO peopleReq){
        if(Objects.isNull(peopleReq.getId())){
            peopleReq.setId(idGenerator.intValue());
            idGenerator++;
        }
    }
}
