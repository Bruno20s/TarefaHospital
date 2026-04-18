package com.example.hospital.model;

import jakarta.persistence.*;

@Entity
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String observacoes;

    @OneToOne
    private Paciente paciente;

    // GETTERS E SETTERS

    public Long getId() {
        return id;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setId(Long id) {
    this.id = id;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}