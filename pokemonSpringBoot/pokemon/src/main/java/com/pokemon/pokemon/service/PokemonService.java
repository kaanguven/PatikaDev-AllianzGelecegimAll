package com.pokemon.pokemon.service;


import com.pokemon.pokemon.database.entity.PokemonEntity;
import com.pokemon.pokemon.database.repository.PokemonRepository;
import com.pokemon.pokemon.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    PokemonRepository pokemonRepository;

    public PokemonEntity createPokemon(String name, int power, String type) {
        PokemonEntity pokemonEntity = new PokemonEntity();
        pokemonEntity.setName(name);
        pokemonEntity.setPower(power);
        pokemonEntity.setType(type);

        pokemonRepository.save(pokemonEntity);
        return pokemonEntity;
    }

    public boolean deletePokemonById(Long id) {
        Optional<PokemonEntity> pokemonOptional = pokemonRepository.findById(id);
        if (pokemonOptional.isPresent()) {
            pokemonRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public PokemonEntity getPikachu() {
        return pokemonRepository.findByNameIgnoreCase("PIKACHU");
    }

    public List<PokemonEntity> getAllPokemon() {
        return pokemonRepository.findAll();
    }


}
