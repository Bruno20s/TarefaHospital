package com.example.hospital.model;

import jakarta.persistence.*;

@Entity
public class Convenio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String numero;

    // GETTERS E SETTERS

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setId(Long id) {
    this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}