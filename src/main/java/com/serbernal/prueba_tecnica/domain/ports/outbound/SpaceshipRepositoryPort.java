package com.serbernal.prueba_tecnica.domain.ports.outbound;

import java.util.List;

import com.serbernal.prueba_tecnica.domain.model.Spaceship;

public interface SpaceshipRepositoryPort extends CommonRepository<Spaceship, Long> {

  List<Spaceship> findByName(String name);
}
