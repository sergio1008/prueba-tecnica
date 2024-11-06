package com.serbernal.prueba_tecnica.application.usecases.impl.spaceship;

import com.serbernal.prueba_tecnica.application.dto.SpaceshipDTO;
import com.serbernal.prueba_tecnica.application.mappers.SpaceshipMapper;
import com.serbernal.prueba_tecnica.application.usecases.spaceship.UpdateSpaceshipUseCase;
import com.serbernal.prueba_tecnica.domain.service.SpaceshipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UpdateSpaceshipUseCaseImpl implements UpdateSpaceshipUseCase {

  private final SpaceshipService spaceshipService;

  private final SpaceshipMapper spaceshipMapper;

  @Override
  public SpaceshipDTO execute(final SpaceshipDTO input) {
    return spaceshipMapper.toDTO(spaceshipService.update(input.getId(), spaceshipMapper.toModel(input)));
  }
}
