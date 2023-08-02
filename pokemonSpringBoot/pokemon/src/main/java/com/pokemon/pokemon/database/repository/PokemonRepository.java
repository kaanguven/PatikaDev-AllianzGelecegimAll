package com.pokemon.pokemon.database.repository;

import com.pokemon.pokemon.database.entity.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PokemonRepository extends JpaRepository<PokemonEntity,Long> {

    PokemonEntity findByNameIgnoreCase(String name);

    List<PokemonEntity> findAll();

}
