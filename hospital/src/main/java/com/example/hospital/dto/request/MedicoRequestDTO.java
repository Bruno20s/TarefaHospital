package com.example.hospital.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicoRequestDTO {

    private String nome;
    private String especialidade;
    private String crm;
}
