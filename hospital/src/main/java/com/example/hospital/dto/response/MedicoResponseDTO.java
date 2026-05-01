package com.example.hospital.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicoResponseDTO {

    private Long id;
    private String nome;
    private String especialidade;
    private String crm;
}
