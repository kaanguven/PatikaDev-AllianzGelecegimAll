package com.pokemon.pokemon.controller;


import com.pokemon.pokemon.database.entity.OwnerEntity;
import com.pokemon.pokemon.database.entity.PokemonEntity;
import com.pokemon.pokemon.database.repository.PokemonRepository;
import com.pokemon.pokemon.model.Owner;
import com.pokemon.pokemon.model.Pokemon;
import com.pokemon.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pokemon")
public class PokemonController {

    @Autowired
    PokemonService pokemonService;
    PokemonRepository pokemonRepository;

    @PostMapping("pokemon")
    public ResponseEntity<PokemonEntity> createPokemon(@RequestBody Pokemon pokemon) {
        PokemonEntity pokemonEntity = pokemonService.createPokemon(pokemon.getName(),pokemon.getPower(),pokemon.getType());
        return new ResponseEntity<>(pokemonEntity, HttpStatus.CREATED);
    }

    @DeleteMapping("pokemon/{id}")
    public ResponseEntity<String> deletePokemon(@PathVariable Long id) {
        boolean isDeleted = pokemonService.deletePokemonById(id);
        if (isDeleted) {
            return new ResponseEntity<>("Pokemon with ID " + id + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Pokemon with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("pokemon/seni-sectim-pikachu")
    public ResponseEntity<PokemonEntity> getPikachu() {
        PokemonEntity pikachuEntity = pokemonService.getPikachu();
        return new ResponseEntity<>(pikachuEntity, HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<List<PokemonEntity>> getAllPokemon() {
        List<PokemonEntity> allPokemon = pokemonService.getAllPokemon();
        return new ResponseEntity<>(allPokemon, HttpStatus.OK);
    }


}
