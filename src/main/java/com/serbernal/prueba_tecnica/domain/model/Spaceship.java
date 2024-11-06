package com.serbernal.prueba_tecnica.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Spaceship {

  private Long id;

  private String name;

  private String registrationNumber;
}
