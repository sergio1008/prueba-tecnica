package com.serbernal.prueba_tecnica.domain.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Paging<T> {
  private int page;

  private int size;

  private long totalItems;

  private int totalPages;

  private List<T> content;

}
