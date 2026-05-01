package com.example.hospital.mapper;

import com.example.hospital.dto.request.ConsultaRequestDTO;
import com.example.hospital.dto.response.ConsultaResponseDTO;
import com.example.hospital.model.Consulta;
import com.example.hospital.model.Medico;
import com.example.hospital.model.Paciente;

public class ConsultaMapper {

    private ConsultaMapper() {
    }

    public static ConsultaResponseDTO toResponseDTO(Consulta consulta) {
        if (consulta == null) return null;
        ConsultaResponseDTO dto = new ConsultaResponseDTO();
        dto.setId(consulta.getId());
        dto.setDataHora(consulta.getDataHora());
        dto.setPaciente(PacienteMapper.toResponseDTO(consulta.getPaciente()));
        dto.setMedico(MedicoMapper.toResponseDTO(consulta.getMedico()));
        return dto;
    }

    public static Consulta toEntity(ConsultaRequestDTO dto, Paciente paciente, Medico medico) {
        if (dto == null) return null;
        Consulta consulta = new Consulta();
        consulta.setDataHora(dto.getDataHora());
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        return consulta;
    }

    public static void updateEntity(Consulta consulta, ConsultaRequestDTO dto, Paciente paciente, Medico medico) {
        consulta.setDataHora(dto.getDataHora());
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
    }
}
