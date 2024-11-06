package com.serbernal.prueba_tecnica.application.usecases.spaceship;

import java.util.List;

import com.serbernal.prueba_tecnica.application.dto.SpaceshipDTO;
import com.serbernal.prueba_tecnica.application.usecases.BaseUseCase;

public interface FindByNameSpaceShipUseCase extends BaseUseCase<String, List<SpaceshipDTO>> {
}
