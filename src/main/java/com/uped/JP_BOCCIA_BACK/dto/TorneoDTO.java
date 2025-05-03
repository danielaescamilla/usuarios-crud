package com.uped.JP_BOCCIA_BACK.dto;

import com.fasterxml.jackson.core.JsonToken;
import com.uped.JP_BOCCIA_BACK.entity.Torneo;
import lombok.*;
import lombok.Builder;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TorneoDTO {
    private Long id;
    private String nombre;
    private Torneo.TipoTorneo tipo;
    private Long paisId; // Suponiendo que solo necesitas el ID del país
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

}


