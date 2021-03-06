package com.example.retrofit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
* No retrofit nossos atributos devem ter o mesmo nome que os atributos retornados na API
* caso não, tem uma propriedade que faz a conversão
* e se quisermos igonorar alguns campos retornados pela API é só utilizar o JsonIgnoreProperties
* */
@JsonIgnoreProperties({"base_experience","is_default","order","abilities","forms",
        "game_indices", "held_items", "location_area_encounters", "moves", "species", "sprites",
        "stats", "types"})
public class Pokemon {

    private int id;
    private String name;
    private int height;
    private int weight;

    public Pokemon() {}

    public Pokemon(int id, String name, int height, int weight) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
