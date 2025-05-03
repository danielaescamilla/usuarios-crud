package com.uped.JP_BOCCIA_BACK.service;


import com.uped.JP_BOCCIA_BACK.dto.TorneoDTO;
import com.uped.JP_BOCCIA_BACK.entity.Torneo;

import java.util.List;

public interface TorneoService {
    List<TorneoDTO> listarTodos();
    Torneo guardar(Torneo torneo);
    TorneoDTO buscarPorId(Long id);
    Torneo actualizar(Long id, Torneo torneo);

    TorneoDTO actualizar(Long id, TorneoDTO torneoDTO);

    void eliminar(Long id);
    List<Torneo> guardarVariosTorneos(List<Torneo> torneos);

    TorneoDTO guardar(TorneoDTO torneoDTO);

    List<TorneoDTO> getAllTorneos();
}