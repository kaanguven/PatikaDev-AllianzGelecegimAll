package com.pokemon.pokemon.database.repository;

import com.pokemon.pokemon.database.entity.ArenaEntity;
import com.pokemon.pokemon.database.entity.OwnerEntity;
import com.pokemon.pokemon.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<OwnerEntity, Long> {

    OwnerEntity findByNameIgnoreCase(String name);

}
