package com.uped.JP_BOCCIA_BACK.service.impl;

import com.uped.JP_BOCCIA_BACK.dto.TorneoDTO;
import com.uped.JP_BOCCIA_BACK.entity.Pais;
import com.uped.JP_BOCCIA_BACK.entity.Torneo;
import com.uped.JP_BOCCIA_BACK.mapper.TorneoMapper;
import com.uped.JP_BOCCIA_BACK.repository.PaisRepository;
import com.uped.JP_BOCCIA_BACK.repository.Torneorepository;
import com.uped.JP_BOCCIA_BACK.service.TorneoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public abstract class TorneoServiceImpl implements TorneoService {

    @Autowired
    private Torneorepository torneorepository;

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public TorneoDTO guardar(TorneoDTO torneoDTO) {
        Pais pais = paisRepository.findById(torneoDTO.getPaisId()).orElse(null);
        Torneo torneo = TorneoMapper.toEntity(torneoDTO, pais);
        torneo = torneorepository.save(torneo);
        return TorneoMapper.toDTO(torneo);
    }

    @Override
    public List<TorneoDTO> listarTodos() {
        return torneorepository.findAll().stream()
                .map(TorneoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TorneoDTO buscarPorId(Long id) {
        return torneorepository.findById(id)
                .map(TorneoMapper::toDTO)
                .orElse(null);
    }

    @Override
    public TorneoDTO actualizar(Long id, TorneoDTO torneoDTO) {
        return torneorepository.findById(id)
                .map(existing -> {
                    Pais pais = paisRepository.findById(torneoDTO.getPaisId()).orElse(null);
                    existing.setNombre(torneoDTO.getNombre());
                    existing.setTipo(torneoDTO.getTipo());
                    existing.setPais(pais);
                    existing.setFechaInicio(torneoDTO.getFechaInicio());
                    existing.setFechaFin(torneoDTO.getFechaFin());
                    torneorepository.save(existing);
                    return TorneoMapper.toDTO(existing);
                })
                .orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        torneorepository.deleteById(id);
    }
}
