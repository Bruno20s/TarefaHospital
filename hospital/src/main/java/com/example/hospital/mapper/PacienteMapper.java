package com.example.hospital.mapper;

import com.example.hospital.dto.request.PacienteRequestDTO;
import com.example.hospital.dto.response.PacienteResponseDTO;
import com.example.hospital.model.Paciente;

public class PacienteMapper {

    private PacienteMapper() {
    }

    public static PacienteResponseDTO toResponseDTO(Paciente paciente) {
        if (paciente == null) return null;
        PacienteResponseDTO dto = new PacienteResponseDTO();
        dto.setId(paciente.getId());
        dto.setNome(paciente.getNome());
        dto.setCpf(paciente.getCpf());
        dto.setTelefone(paciente.getTelefone());
        return dto;
    }

    public static Paciente toEntity(PacienteRequestDTO dto) {
        if (dto == null) return null;
        Paciente paciente = new Paciente();
        paciente.setNome(dto.getNome());
        paciente.setCpf(dto.getCpf());
        paciente.setTelefone(dto.getTelefone());
        return paciente;
    }

    public static void updateEntity(Paciente paciente, PacienteRequestDTO dto) {
        paciente.setNome(dto.getNome());
        paciente.setCpf(dto.getCpf());
        paciente.setTelefone(dto.getTelefone());
    }
}
