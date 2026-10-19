package com.practica01.practica01.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "suculenta")
public class Suculenta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_suculenta")
    private Integer idSuculenta;

    @Column(nullable = false, length = 60)
    @NotBlank
    @Size(max = 60)
    private String nombreComun;

    @Column(nullable = false, length = 80)
    @NotBlank
    @Size(max = 80)
    private String nombreCientifico;

    @Column(nullable = false, length = 50)
    @NotBlank
    @Size(max = 50)
    private String familia;

    @Column(nullable = false, length = 30)
    @NotBlank
    @Size(max = 30)
    private String colorPrincipal;

    @Column(nullable = false, precision = 5, scale = 1)
    @NotNull
    @Positive
    private BigDecimal alturaCm;

    @Column(nullable = false, precision = 10, scale = 2)
    @NotNull
    @PositiveOrZero
    private BigDecimal precioEstimado;

    @Column(nullable = false, length = 10)
    @NotBlank
    @Size(max = 10)
    private String nivelRiego;

    @Column(nullable = false, length = 1024)
    @NotBlank
    @Size(max = 1024)
    private String rutaImagen;
}
