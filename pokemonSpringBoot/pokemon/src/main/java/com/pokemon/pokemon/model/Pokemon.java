package com.pokemon.pokemon.model;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Pokemon {

    String name;

    int power;

    private UUID uuid;

    private String type;
    public Pokemon() {
        this.uuid = UUID.randomUUID();
    }


}
