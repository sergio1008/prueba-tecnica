package com.serbernal.prueba_tecnica.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Page {

  private int page;

  private int size;
}
