package com.uped.JP_BOCCIA_BACK.mapper;

import com.uped.JP_BOCCIA_BACK.dto.TorneoDTO;
import com.uped.JP_BOCCIA_BACK.entity.Pais;
import com.uped.JP_BOCCIA_BACK.entity.Torneo;

public class TorneoMapper {

    public static TorneoDTO toDTO(Torneo torneo) {
        return TorneoDTO.builder()
                .id(torneo.getId())
                .nombre(torneo.getNombre())
                .tipo(torneo.getTipo())
                .paisId(torneo.getPais() != null ? torneo.getPais().getId() : null)
                .fechaInicio(torneo.getFechaInicio())
                .fechaFin(torneo.getFechaFin())
                .build();
    }

    public static Torneo toEntity(TorneoDTO dto, Pais pais) {
        return Torneo.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .tipo(dto.getTipo())
                .pais(pais)
                .fechaInicio(dto.getFechaInicio())
                .fechaFin(dto.getFechaFin())
                .build();
    }

}

