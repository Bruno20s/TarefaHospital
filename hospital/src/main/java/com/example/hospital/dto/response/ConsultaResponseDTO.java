package com.example.hospital.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaResponseDTO {

    private Long id;
    private LocalDateTime dataHora;
    private PacienteResponseDTO paciente;
    private MedicoResponseDTO medico;
}
