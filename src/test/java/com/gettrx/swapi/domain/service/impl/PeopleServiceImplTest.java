package com.gettrx.swapi.domain.service.impl;

import com.gettrx.swapi.domain.dto.PeopleDTO;
import com.gettrx.swapi.domain.repository.PeopleRepository;
import com.gettrx.swapi.external.SwapiWebClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.DoesNothing;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
class PeopleServiceImplTest {

    @Mock
    private PeopleRepository peopleRepository;
    @Mock
    private SwapiWebClient swapiWebClient;
    @InjectMocks
    private PeopleServiceImpl peopleServiceImpl;

    @BeforeEach
    void setUp() {

    }

    @Test
    void getAll() {
    }

    @Test
    void getPeopleByPagePeopleDTO() {
        PeopleDTO peopleDTO = new PeopleDTO();
        peopleDTO.setId(0);
        List<PeopleDTO> listPeopleDTO = new ArrayList<>();
        listPeopleDTO.add(peopleDTO);
        when(swapiWebClient.getPeopleByPage(Mockito.anyInt())).thenReturn(Optional.of(listPeopleDTO));
        when(peopleRepository.save(Mockito.any(PeopleDTO.class))).thenReturn(peopleDTO);

        List<PeopleDTO> listPeopleDTORep = peopleServiceImpl.getPeopleByPage(1);
        assertEquals("Test getPeopleByPage",0, listPeopleDTORep.get(0).getId());

    }

    @Test
    void getPeoplePeopleDTO() {

        PeopleDTO peopleDTO = new PeopleDTO();
        peopleDTO.setId(0);

        when(swapiWebClient.getPeople(Mockito.anyInt())).thenReturn(Optional.of(peopleDTO));
        when(peopleRepository.save(Mockito.any(PeopleDTO.class))).thenReturn(peopleDTO);

        PeopleDTO peopleDTORep = peopleServiceImpl.getPeople(1);
        assertEquals("Test getPeople",0, peopleDTORep.getId());
    }

    @Test
    void savePeopleDTO() {
        PeopleDTO peopleDTO = new PeopleDTO();
        peopleDTO.setId(0);
        peopleDTO.setName("");
        peopleDTO.setBirth_year("");
        peopleDTO.setEye_color("");
        peopleDTO.setGender("");
        peopleDTO.setHair_color("");
        peopleDTO.setHeight("");
        peopleDTO.setHomeworld("");
        peopleDTO.setMass("");
        peopleDTO.setSkin_color("");
        peopleDTO.setCreated("");
        peopleDTO.setEdited("");
        peopleDTO.setUrl("");
        when(peopleRepository.save(Mockito.any(PeopleDTO.class))).thenReturn(peopleDTO);

        PeopleDTO peopleDTORep = peopleServiceImpl.save(peopleDTO);
        assertEquals("Test getPeople",0, peopleDTORep.getId());
    }

    @Test
    void testDeletePeopleDTO() {
        PeopleDTO peopleDTO = new PeopleDTO();
        peopleDTO.setId(0);
        when(peopleRepository.getPeople(Mockito.anyInt())).thenReturn(Optional.of(peopleDTO));
        doNothing().when(peopleRepository).delete(Mockito.anyInt());

        Boolean peopleRep = peopleServiceImpl.delete(1);
        assertEquals("Test Delete People",Boolean.TRUE, peopleRep);
    }
}