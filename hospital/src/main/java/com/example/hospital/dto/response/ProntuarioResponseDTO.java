package com.example.hospital.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProntuarioResponseDTO {

    private Long id;
    private String observacoes;
    private PacienteResponseDTO paciente;
}
