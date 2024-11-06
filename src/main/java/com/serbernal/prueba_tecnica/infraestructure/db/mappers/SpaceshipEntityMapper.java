package com.serbernal.prueba_tecnica.infraestructure.db.mappers;

import com.serbernal.prueba_tecnica.domain.model.Spaceship;
import com.serbernal.prueba_tecnica.infraestructure.db.entity.SpaceshipEntity;
import org.mapstruct.Mapper;

@Mapper
public interface SpaceshipEntityMapper {
  SpaceshipEntity toEntity(Spaceship domain);

  Spaceship toDomain(SpaceshipEntity entity);

}
