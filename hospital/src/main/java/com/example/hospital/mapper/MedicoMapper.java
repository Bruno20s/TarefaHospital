package com.example.hospital.mapper;

import com.example.hospital.dto.request.MedicoRequestDTO;
import com.example.hospital.dto.response.MedicoResponseDTO;
import com.example.hospital.model.Medico;

public class MedicoMapper {

    private MedicoMapper() {
    }

    public static MedicoResponseDTO toResponseDTO(Medico medico) {
        if (medico == null) return null;
        MedicoResponseDTO dto = new MedicoResponseDTO();
        dto.setId(medico.getId());
        dto.setNome(medico.getNome());
        dto.setEspecialidade(medico.getEspecialidade());
        dto.setCrm(medico.getCrm());
        return dto;
    }

    public static Medico toEntity(MedicoRequestDTO dto) {
        if (dto == null) return null;
        Medico medico = new Medico();
        medico.setNome(dto.getNome());
        medico.setEspecialidade(dto.getEspecialidade());
        medico.setCrm(dto.getCrm());
        return medico;
    }

    public static void updateEntity(Medico medico, MedicoRequestDTO dto) {
        medico.setNome(dto.getNome());
        medico.setEspecialidade(dto.getEspecialidade());
        medico.setCrm(dto.getCrm());
    }
}
