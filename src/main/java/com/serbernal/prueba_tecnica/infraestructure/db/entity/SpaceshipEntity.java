package com.serbernal.prueba_tecnica.infraestructure.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "naves_espaciales")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpaceshipEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nombre")
  private String name;

  @Column(name = "matricula")
  private String registrationNumber;
}
