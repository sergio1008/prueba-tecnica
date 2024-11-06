package com.serbernal.prueba_tecnica.domain.service;

import java.util.List;

import com.serbernal.prueba_tecnica.domain.model.Paging;
import com.serbernal.prueba_tecnica.domain.model.Spaceship;
import org.springframework.transaction.annotation.Transactional;

public interface SpaceshipService {
  @Transactional
  Spaceship create(Spaceship spaceship);

  @Transactional
  Spaceship update(Long id, Spaceship spaceship);

  void delete(Long id);

  Spaceship findById(Long id);

  Paging<Spaceship> findAll(int page, int size);

  List<Spaceship> findByName(String name);
}
