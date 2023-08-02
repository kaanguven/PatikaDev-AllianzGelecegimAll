package com.pokemon.pokemon.model;


import lombok.Getter;
import lombok.Setter;
import lombok.Data;
import java.util.UUID;

@Getter
@Setter
public class Arena {

    String name;
    private UUID uuid;

    private int capacity;

    public Arena() {
        this.uuid = UUID.randomUUID();
    }
}
