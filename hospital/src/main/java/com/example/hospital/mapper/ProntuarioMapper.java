package com.example.hospital.mapper;

import com.example.hospital.dto.request.ProntuarioRequestDTO;
import com.example.hospital.dto.response.ProntuarioResponseDTO;
import com.example.hospital.model.Paciente;
import com.example.hospital.model.Prontuario;

public class ProntuarioMapper {

    private ProntuarioMapper() {
    }

    public static ProntuarioResponseDTO toResponseDTO(Prontuario prontuario) {
        if (prontuario == null) return null;
        ProntuarioResponseDTO dto = new ProntuarioResponseDTO();
        dto.setId(prontuario.getId());
        dto.setObservacoes(prontuario.getObservacoes());
        dto.setPaciente(PacienteMapper.toResponseDTO(prontuario.getPaciente()));
        return dto;
    }

    public static Prontuario toEntity(ProntuarioRequestDTO dto, Paciente paciente) {
        if (dto == null) return null;
        Prontuario prontuario = new Prontuario();
        prontuario.setObservacoes(dto.getObservacoes());
        prontuario.setPaciente(paciente);
        return prontuario;
    }

    public static void updateEntity(Prontuario prontuario, ProntuarioRequestDTO dto, Paciente paciente) {
        prontuario.setObservacoes(dto.getObservacoes());
        prontuario.setPaciente(paciente);
    }
}
