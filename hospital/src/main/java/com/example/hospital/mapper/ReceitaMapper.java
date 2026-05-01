package com.example.hospital.mapper;

import com.example.hospital.dto.request.ReceitaRequestDTO;
import com.example.hospital.dto.response.ReceitaResponseDTO;
import com.example.hospital.model.Consulta;
import com.example.hospital.model.Receita;

public class ReceitaMapper {

    private ReceitaMapper() {
    }

    public static ReceitaResponseDTO toResponseDTO(Receita receita) {
        if (receita == null) return null;
        ReceitaResponseDTO dto = new ReceitaResponseDTO();
        dto.setId(receita.getId());
        dto.setDescricao(receita.getDescricao());
        dto.setConsulta(ConsultaMapper.toResponseDTO(receita.getConsulta()));
        return dto;
    }

    public static Receita toEntity(ReceitaRequestDTO dto, Consulta consulta) {
        if (dto == null) return null;
        Receita receita = new Receita();
        receita.setDescricao(dto.getDescricao());
        receita.setConsulta(consulta);
        return receita;
    }

    public static void updateEntity(Receita receita, ReceitaRequestDTO dto, Consulta consulta) {
        receita.setDescricao(dto.getDescricao());
        receita.setConsulta(consulta);
    }
}
