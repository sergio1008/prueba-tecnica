package com.serbernal.prueba_tecnica.infraestructure.db.adapters;

import java.util.List;
import java.util.stream.Collectors;

import com.serbernal.prueba_tecnica.domain.model.Paging;
import com.serbernal.prueba_tecnica.domain.model.Spaceship;
import com.serbernal.prueba_tecnica.domain.ports.outbound.SpaceshipRepositoryPort;
import com.serbernal.prueba_tecnica.infraestructure.db.mappers.SpaceshipEntityMapper;
import com.serbernal.prueba_tecnica.infraestructure.db.repository.SpaceshipRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SpaceshipRepositoryPortAdapter implements SpaceshipRepositoryPort {

  private final SpaceshipEntityMapper spaceshipEntityMapper;

  private final SpaceshipRepository repository;

  @Override
  public Spaceship save(final Spaceship model) {
    return spaceshipEntityMapper.toDomain(repository.save(spaceshipEntityMapper.toEntity(model)));
  }

  @Override
  public Paging<Spaceship> findAll(final int page, final int size) {
    final Pageable pageable = PageRequest.of(page, size);
    final Page<Spaceship> pageResult = repository.findAll(pageable).map(spaceshipEntityMapper::toDomain);
    return Paging.<Spaceship>builder()
        .page(pageResult.getNumber())
        .totalItems(pageResult.getTotalElements())
        .totalPages(pageResult.getTotalPages())
        .size(pageResult.getSize())
        .content(pageResult.getContent())
        .build();
  }

  @Override
  public void delete(final Long id) {
    repository.deleteById(id);
  }

  @Override
  public Spaceship update(final Long aLong, final Spaceship model) {
    return spaceshipEntityMapper.toDomain(repository.save(spaceshipEntityMapper.toEntity(model)));
  }

  @Override
  public Spaceship findById(final Long id) {
    return repository.findById(id).map(spaceshipEntityMapper::toDomain).orElseThrow();
  }

  @Override
  public List<Spaceship> findByName(final String name) {
    return repository.findByNameContaining(name).stream().map(spaceshipEntityMapper::toDomain).collect(Collectors.toList());
  }
}
