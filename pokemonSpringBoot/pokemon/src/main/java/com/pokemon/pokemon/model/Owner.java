package com.pokemon.pokemon.model;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Owner {

    String name;

    int power;

    private UUID uuid;

    public Owner() {
        this.uuid = UUID.randomUUID();
    }

}
