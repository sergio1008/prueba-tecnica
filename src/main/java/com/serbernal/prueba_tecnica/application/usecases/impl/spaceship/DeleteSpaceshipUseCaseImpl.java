package com.serbernal.prueba_tecnica.application.usecases.impl.spaceship;

import com.serbernal.prueba_tecnica.application.mappers.SpaceshipMapper;
import com.serbernal.prueba_tecnica.application.usecases.spaceship.DeleteSpaceshipUseCase;
import com.serbernal.prueba_tecnica.domain.service.SpaceshipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DeleteSpaceshipUseCaseImpl implements DeleteSpaceshipUseCase {

  private final SpaceshipService spaceshipService;

  private final SpaceshipMapper spaceshipMapper;

  @Override
  public Void execute(final Long input) {
    spaceshipService.delete(input);
    return null;
  }
}
