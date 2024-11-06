package com.serbernal.prueba_tecnica.domain.ports.outbound;

import com.serbernal.prueba_tecnica.domain.model.Paging;

public interface CommonRepository<T, Id> {

  T save(T model);

  Paging<T> findAll(int page, int size);

  void delete(Id id);

  T update(Id id, T model);

  T findById(Id id);

}
