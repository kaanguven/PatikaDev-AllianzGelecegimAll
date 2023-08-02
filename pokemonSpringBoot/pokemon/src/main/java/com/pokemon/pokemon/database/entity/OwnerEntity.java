package com.pokemon.pokemon.database.entity;


import com.pokemon.pokemon.util.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "owner")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "owner_uuid"
        )
)
@Data
public class OwnerEntity extends BaseEntity {
    @Column
    String name;


    @Column
    int power;


}
