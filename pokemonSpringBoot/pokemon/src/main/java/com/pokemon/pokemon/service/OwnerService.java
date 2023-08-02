package com.pokemon.pokemon.service;


import com.pokemon.pokemon.database.entity.OwnerEntity;
import com.pokemon.pokemon.database.repository.OwnerRepository;
import com.pokemon.pokemon.database.repository.PokemonRepository;
import com.pokemon.pokemon.model.Owner;
import com.pokemon.pokemon.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    OwnerRepository ownerRepository;

    public OwnerEntity createOwner(String name, int power) {
        OwnerEntity ownerEntity = new OwnerEntity();
        ownerEntity.setName(name);
        ownerEntity.setPower(power);

        ownerRepository.save(ownerEntity);

        return ownerEntity;
    }

    public OwnerEntity updateOwner(Long id, Owner updatedOwner) {
        Optional<OwnerEntity> ownerOptional = ownerRepository.findById(id);
        if (ownerOptional.isPresent()) {
            OwnerEntity ownerEntity = ownerOptional.get();
            ownerEntity.setName(updatedOwner.getName());
            ownerEntity.setPower(updatedOwner.getPower());
            return ownerRepository.save(ownerEntity);
        } else {
            return null; // Owner with the given ID not found
        }
    }

    public OwnerEntity getOwnerByName(String name) {
        return ownerRepository.findByNameIgnoreCase(name);
    }



}
