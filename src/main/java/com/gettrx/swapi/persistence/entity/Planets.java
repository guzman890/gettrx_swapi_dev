package com.gettrx.swapi.persistence.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "planets")
public class Planets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name= "id")
    private Integer id;

    @Column(name= "climate")
    private String climate;
    @Column(name= "diameter")
    private String diameter;
    @Column(name= "gravity")
    private String gravity;
    @Column(name= "name")
    private String name;
    @Column(name= "population")
    private String population;
    @Column(name= "residents")
    private String residents;
    @Column(name= "terrain")
    private String terrain;
    @Column(name= "url")
    private String url;
}
