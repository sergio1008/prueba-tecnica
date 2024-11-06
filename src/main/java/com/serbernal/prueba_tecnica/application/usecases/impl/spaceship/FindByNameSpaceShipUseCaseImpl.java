package com.serbernal.prueba_tecnica.application.usecases.impl.spaceship;

import java.util.List;
import java.util.stream.Collectors;

import com.serbernal.prueba_tecnica.application.dto.SpaceshipDTO;
import com.serbernal.prueba_tecnica.application.mappers.SpaceshipMapper;
import com.serbernal.prueba_tecnica.application.usecases.spaceship.FindByNameSpaceShipUseCase;
import com.serbernal.prueba_tecnica.domain.service.SpaceshipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class FindByNameSpaceShipUseCaseImpl implements FindByNameSpaceShipUseCase {

  private final SpaceshipService spaceshipService;

  private final SpaceshipMapper spaceshipMapper;

  @Override
  public List<SpaceshipDTO> execute(final String input) {
    return spaceshipService.findByName(input).stream()
        .map(spaceshipMapper::toDTO).collect(Collectors.toList());
  }
}
