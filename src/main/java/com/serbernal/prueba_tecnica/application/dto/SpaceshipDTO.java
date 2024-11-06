package com.serbernal.prueba_tecnica.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SpaceshipDTO {
  private Long id;

  @NotEmpty
  @NotBlank
  private String name;

  @NotEmpty
  @NotBlank
  private String registrationNumber;
}
