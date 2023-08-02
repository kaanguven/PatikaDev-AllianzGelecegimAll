package com.pokemon.pokemon.database.entity;


import com.fasterxml.jackson.databind.ser.Serializers;
import com.pokemon.pokemon.util.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "arena")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "arena_uuid"
        )
)
@Data
public class ArenaEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private int capacity;
}
