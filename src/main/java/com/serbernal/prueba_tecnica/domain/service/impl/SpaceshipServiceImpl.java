package com.serbernal.prueba_tecnica.domain.service.impl;

import java.util.List;

import com.serbernal.prueba_tecnica.domain.model.Paging;
import com.serbernal.prueba_tecnica.domain.model.Spaceship;
import com.serbernal.prueba_tecnica.domain.ports.outbound.SpaceshipRepositoryPort;
import com.serbernal.prueba_tecnica.domain.service.SpaceshipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@AllArgsConstructor
@Service
public class SpaceshipServiceImpl implements SpaceshipService {

  private final SpaceshipRepositoryPort repository;

  @Override
  public Spaceship create(final Spaceship spaceship) {
    Assert.hasText(spaceship.getName(), "Name is required");

    return repository.save(spaceship);
  }

  @Override
  public Spaceship update(final Long id, final Spaceship spaceship) {
    Assert.hasText(spaceship.getName(), "Name is required");
    return repository.update(id, spaceship);
  }

  @Override
  public void delete(final Long id) {
    repository.delete(id);
  }

  @Override
  public Spaceship findById(final Long id) {
    return repository.findById(id);
  }

  @Override
  public Paging<Spaceship> findAll(final int page, final int size) {
    return repository.findAll(page, size);
  }

  @Override
  public List<Spaceship> findByName(final String name) {
    return repository.findByName(name);
  }
}
