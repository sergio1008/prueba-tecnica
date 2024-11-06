package com.serbernal.prueba_tecnica.application.usecases.impl.spaceship;

import com.serbernal.prueba_tecnica.application.dto.SpaceshipDTO;
import com.serbernal.prueba_tecnica.application.mappers.SpaceshipMapper;
import com.serbernal.prueba_tecnica.application.usecases.spaceship.FindByIdSpaceshipUseCase;
import com.serbernal.prueba_tecnica.domain.service.SpaceshipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class FindByIdSpaceshipUseCaseImpl implements FindByIdSpaceshipUseCase {

  private final SpaceshipService spaceshipService;

  private final SpaceshipMapper spaceshipMapper;

  @Override
  public SpaceshipDTO execute(final Long input) {
    return spaceshipMapper.toDTO(spaceshipService.findById(input));
  }
}
