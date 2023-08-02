package com.pokemon.pokemon.database.repository;

import com.pokemon.pokemon.database.entity.ArenaEntity;
import com.pokemon.pokemon.model.Arena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArenaRepository extends JpaRepository<ArenaEntity, Long> {

    List<ArenaEntity> findByNameEndingWith(String suffix);
}