package com.example.hospital.dto.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaRequestDTO {

    private LocalDateTime dataHora;
    private Long pacienteId;
    private Long medicoId;
}
