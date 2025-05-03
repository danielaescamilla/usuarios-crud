package com.uped.JP_BOCCIA_BACK.repository;

import com.uped.JP_BOCCIA_BACK.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRespository extends JpaRepository<Evento, Long> {
}

