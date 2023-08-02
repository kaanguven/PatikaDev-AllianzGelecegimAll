package com.pokemon.pokemon.service;


import com.pokemon.pokemon.database.entity.ArenaEntity;
import com.pokemon.pokemon.database.repository.ArenaRepository;
import com.pokemon.pokemon.model.Arena;
import com.pokemon.pokemon.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArenaService {


    @Autowired
    ArenaRepository arenaRepository;

    public ArenaEntity createArena(String name) {
        ArenaEntity arenaEntity = new ArenaEntity();
        arenaEntity.setName(name);


        arenaRepository.save(arenaEntity);

        return arenaEntity;
    }

    public List<ArenaEntity> getArenasWithSuffixHo() {
        return arenaRepository.findByNameEndingWith("e");
    }
}
