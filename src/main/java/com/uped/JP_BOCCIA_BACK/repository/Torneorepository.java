package com.uped.JP_BOCCIA_BACK.repository;

import com.uped.JP_BOCCIA_BACK.entity.Torneo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Torneorepository extends JpaRepository<Torneo, Long> {
}