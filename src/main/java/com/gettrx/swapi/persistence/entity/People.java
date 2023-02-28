package com.gettrx.swapi.persistence.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "people")
public class People {
    @Id
    @Column (name= "id")
    private Integer id;
    @Column(name= "name")
    private String name;
    @Column(name= "birth_year")
    private String birth_year;
    @Column(name= "eye_color")
    private String eye_color;
    @Column(name= "gender")
    private String gender;
    @Column(name= "hair_color")
    private String hair_color;
    @Column(name= "height")
    private String height;
    @Column(name= "homeworld")
    private String homeworld;
    @Column(name= "mass")
    private String mass;
    @Column(name= "skin_color")
    private String skin_color;
    @Column(name= "created")
    private String created;
    @Column(name= "edited")
    private String edited;
    @Column(name= "url")
    private String url;
}
