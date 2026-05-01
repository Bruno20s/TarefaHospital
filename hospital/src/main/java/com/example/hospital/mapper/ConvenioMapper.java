package com.example.hospital.mapper;

import com.example.hospital.dto.request.ConvenioRequestDTO;
import com.example.hospital.dto.response.ConvenioResponseDTO;
import com.example.hospital.model.Convenio;

public class ConvenioMapper {

    private ConvenioMapper() {
    }

    public static ConvenioResponseDTO toResponseDTO(Convenio convenio) {
        if (convenio == null) return null;
        ConvenioResponseDTO dto = new ConvenioResponseDTO();
        dto.setId(convenio.getId());
        dto.setNome(convenio.getNome());
        dto.setNumero(convenio.getNumero());
        return dto;
    }

    public static Convenio toEntity(ConvenioRequestDTO dto) {
        if (dto == null) return null;
        Convenio convenio = new Convenio();
        convenio.setNome(dto.getNome());
        convenio.setNumero(dto.getNumero());
        return convenio;
    }

    public static void updateEntity(Convenio convenio, ConvenioRequestDTO dto) {
        convenio.setNome(dto.getNome());
        convenio.setNumero(dto.getNumero());
    }
}
