package com.serbernal.prueba_tecnica.application.usecases.impl.spaceship;

import java.util.List;
import java.util.stream.Collectors;

import com.serbernal.prueba_tecnica.application.dto.SpaceshipDTO;
import com.serbernal.prueba_tecnica.application.mappers.SpaceshipMapper;
import com.serbernal.prueba_tecnica.application.usecases.spaceship.FindAllSpaceshipUseCase;
import com.serbernal.prueba_tecnica.domain.model.Page;
import com.serbernal.prueba_tecnica.domain.model.Paging;
import com.serbernal.prueba_tecnica.domain.model.Spaceship;
import com.serbernal.prueba_tecnica.domain.service.SpaceshipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class FindAllSpaceshipUseCaseImpl implements FindAllSpaceshipUseCase {
  private final SpaceshipService spaceshipService;

  private final SpaceshipMapper spaceshipMapper;

  @Override
  public Paging<SpaceshipDTO> execute(final Page page) {

    final Paging<Spaceship> result = spaceshipService.findAll(page.getPage(), page.getSize());

    final List<SpaceshipDTO> spaceships = result.getContent().stream()
        .map(spaceshipMapper::toDTO).collect(Collectors.toList());

    return Paging.<SpaceshipDTO>builder()
        .size(result.getSize())
        .page(result.getPage())
        .totalPages(result.getTotalPages())
        .totalItems(result.getTotalItems())
        .content(spaceships)
        .build();
  }
}
