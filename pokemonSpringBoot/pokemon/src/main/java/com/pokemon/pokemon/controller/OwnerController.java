package com.pokemon.pokemon.controller;


import com.pokemon.pokemon.database.entity.ArenaEntity;
import com.pokemon.pokemon.database.entity.OwnerEntity;
import com.pokemon.pokemon.database.entity.PokemonEntity;
import com.pokemon.pokemon.database.repository.OwnerRepository;
import com.pokemon.pokemon.model.Arena;
import com.pokemon.pokemon.model.Owner;
import com.pokemon.pokemon.service.OwnerService;
import com.pokemon.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("owner")
public class OwnerController {


    @Autowired
    OwnerService ownerService;

    @Autowired
    PokemonService pokemonService;


    @PostMapping("owner")
    public ResponseEntity<OwnerEntity> createOwner(@RequestBody Owner owner) {
        OwnerEntity owner1 = ownerService.createOwner(owner.getName(),owner.getPower());
        return new ResponseEntity<>(owner1, HttpStatus.CREATED);
    }

    @PutMapping("owner/{id}")
    public ResponseEntity<OwnerEntity> updateOwner(@PathVariable Long id, @RequestBody Owner updatedOwner) {
        OwnerEntity updatedOwnerEntity = ownerService.updateOwner(id, updatedOwner);
        if (updatedOwnerEntity != null) {
            return new ResponseEntity<>(updatedOwnerEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("owner/ash-pikachuyu-secsin")
    public ResponseEntity<List<Object>> selectAshAndPikachu() {
        PokemonEntity pikachuEntity = pokemonService.getPikachu();

        OwnerEntity ashEntity = ownerService.getOwnerByName("ASH");

        List<Object> resultList = new ArrayList<>();
        resultList.add(ashEntity);
        resultList.add(pikachuEntity);

        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }



}
