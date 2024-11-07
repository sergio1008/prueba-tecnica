package com.serbernal.prueba_tecnica.infraestructure.api;

import java.util.List;

import com.serbernal.prueba_tecnica.application.dto.SpaceshipDTO;
import com.serbernal.prueba_tecnica.application.usecases.spaceship.*;
import com.serbernal.prueba_tecnica.domain.model.Page;
import com.serbernal.prueba_tecnica.domain.model.Paging;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spaceship")
@AllArgsConstructor
public class SpaceshipRestController {

  private final SaveSpaceshipUseCase saveSpaceshipUseCase;

  private final FindAllSpaceshipUseCase findAllSpaceshipUseCase;

  private final FindByNameSpaceShipUseCase findByNameSpaceShipUseCase;

  private final FindByIdSpaceshipUseCase findByIdSpaceshipUseCase;

  private final UpdateSpaceshipUseCase updateSpaceshipUseCase;

  private final DeleteSpaceshipUseCase deleteSpaceshipUseCase;

  @PostMapping
  public ResponseEntity<SpaceshipDTO> save(@RequestBody @Valid final SpaceshipDTO spaceshipDTO) {
    return ResponseEntity.ok(saveSpaceshipUseCase.execute(spaceshipDTO));
  }

  @GetMapping
  public ResponseEntity<Paging<SpaceshipDTO>> findAll(final Pageable pageable) {

    return ResponseEntity.ok(findAllSpaceshipUseCase.execute(Page.builder()
        .page(pageable.getPageNumber())
        .size(pageable.getPageSize())
        .build()));
  }

  @GetMapping("/find-by-name/{name}")
  public ResponseEntity<List<SpaceshipDTO>> findByName(@PathVariable(name = "name") final String name) {
    return ResponseEntity.ok(findByNameSpaceShipUseCase.execute(name));
  }

  @GetMapping("/{id}")
  public ResponseEntity<SpaceshipDTO> findById(@PathVariable(name = "id") final Long id) {
    return ResponseEntity.ok(findByIdSpaceshipUseCase.execute(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable(name = "id") final Long id) {
    return ResponseEntity.ok(deleteSpaceshipUseCase.execute(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<SpaceshipDTO> update(@PathVariable(name = "id") final Long id,
      @RequestBody @Valid final SpaceshipDTO spaceshipDTO) {
    findByIdSpaceshipUseCase.execute(id);
    spaceshipDTO.setId(id);
    return ResponseEntity.ok(updateSpaceshipUseCase.execute(spaceshipDTO));
  }
}
