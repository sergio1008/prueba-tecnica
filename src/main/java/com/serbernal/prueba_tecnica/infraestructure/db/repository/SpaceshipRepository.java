package com.serbernal.prueba_tecnica.infraestructure.db.repository;

import java.util.List;

import com.serbernal.prueba_tecnica.infraestructure.db.entity.SpaceshipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceshipRepository extends JpaRepository<SpaceshipEntity, Long> {

  List<SpaceshipEntity> findByNameContaining(String name);
}
