package com.pokemon.pokemon.controller;


import com.pokemon.pokemon.database.entity.ArenaEntity;
import com.pokemon.pokemon.model.Arena;
import com.pokemon.pokemon.service.ArenaService;
import com.pokemon.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("arena")
public class ArenaController {

    @Autowired
    ArenaService arenaService;

    @PostMapping("arena")
    public ResponseEntity<ArenaEntity> createArena(@RequestBody Arena arena) {
        ArenaEntity arena1 = arenaService.createArena(arena.getName());
        return new ResponseEntity<>(arena1, HttpStatus.CREATED);
    }

    @GetMapping("endsWith")
    public ResponseEntity<List<ArenaEntity>> getArenasWithSuffixHo() {
        List<ArenaEntity> arenasWithSuffixHo = arenaService.getArenasWithSuffixHo();
        return new ResponseEntity<>(arenasWithSuffixHo, HttpStatus.OK);
    }



}
