package com.serbernal.prueba_tecnica.domain.service.impl;

import com.serbernal.prueba_tecnica.domain.model.Spaceship;
import com.serbernal.prueba_tecnica.domain.ports.outbound.SpaceshipRepositoryPort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class SpaceshipServiceImplTest {

  @Mock
  private SpaceshipRepositoryPort repository;

  @InjectMocks
  private SpaceshipServiceImpl service;

  private AutoCloseable closeable;

  @Test
  void given_a_spaceship_When_save_a_spaceship_Then_repository_save_must_be_called() {
    final Spaceship spaceship = Spaceship.builder()
        .name("name")
        .id(1L)
        .registrationNumber("registrationNumber")
        .build();
    Mockito.when(repository.save(spaceship)).thenReturn(spaceship);
    final Spaceship result = service.create(spaceship);

    Assertions.assertEquals(spaceship, result);
    Mockito.verify(repository).save(spaceship);
  }

  @Test
  void given_a_spaceship_When_update_a_spaceship_Then_repository_update_must_be_called() {
    final Spaceship spaceship = Spaceship.builder()
        .name("name")
        .id(1L)
        .registrationNumber("registrationNumber")
        .build();
    Mockito.when(repository.update(1L, spaceship)).thenReturn(spaceship);
    final Spaceship result = service.update(1L, spaceship);

    Assertions.assertEquals(spaceship, result);
    Mockito.verify(repository).update(1L, spaceship);
  }

  @Test
  void given_a_spaceship_id_When_delete_a_spaceship_Then_repository_delete_must_be_called() {
    Mockito.doNothing().when(repository).delete(1L);

    service.delete(1L);

    Mockito.verify(repository).delete(1L);
  }

  @Test
  void given_a_spaceship_id_When_find_a_spaceship_Then_repository_find_by_id_must_be_called() {
    final Spaceship spaceship = Spaceship.builder()
        .name("name")
        .id(1L)
        .registrationNumber("registrationNumber")
        .build();
    Mockito.when(repository.findById(1L)).thenReturn(spaceship);

    Assertions.assertEquals(spaceship, service.findById(1L));
    Mockito.verify(repository).findById(1L);
  }

  @BeforeEach
  public void setup() {
    closeable = MockitoAnnotations.openMocks(this);
  }

  @AfterEach
  public void close() throws Exception {
    closeable.close();
  }
}
