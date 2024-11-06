package com.serbernal.prueba_tecnica.application.mappers;

import com.serbernal.prueba_tecnica.application.dto.SpaceshipDTO;
import com.serbernal.prueba_tecnica.domain.model.Spaceship;
import org.mapstruct.Mapper;

@Mapper
public interface SpaceshipMapper {
  SpaceshipDTO toDTO(Spaceship spaceship);

  Spaceship toModel(SpaceshipDTO spaceshipDTO);
}
