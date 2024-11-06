package com.serbernal.prueba_tecnica.application.usecases;

public interface BaseUseCase<IN, OUT> {
  OUT execute(IN input);
}
