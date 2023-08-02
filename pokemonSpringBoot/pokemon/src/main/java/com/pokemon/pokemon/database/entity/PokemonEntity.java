package com.pokemon.pokemon.database.entity;

import com.pokemon.pokemon.util.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "pokemon")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "pokemon_uuid"
        )
)
@Data
public class PokemonEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private int power;


    @Column
    private String type;




}
