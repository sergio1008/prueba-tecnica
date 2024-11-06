package com.serbernal.prueba_tecnica.application.usecases.spaceship;

import com.serbernal.prueba_tecnica.application.dto.SpaceshipDTO;
import com.serbernal.prueba_tecnica.application.usecases.BaseUseCase;
import com.serbernal.prueba_tecnica.domain.model.Page;
import com.serbernal.prueba_tecnica.domain.model.Paging;

public interface FindAllSpaceshipUseCase extends BaseUseCase<Page, Paging<SpaceshipDTO>> {
}
