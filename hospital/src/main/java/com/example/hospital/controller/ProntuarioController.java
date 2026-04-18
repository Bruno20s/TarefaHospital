package com.example.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.hospital.model.Prontuario;
import com.example.hospital.service.ProntuarioService;

@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {

    @Autowired
    private ProntuarioService service;

    @GetMapping
    public List<Prontuario> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Prontuario buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Prontuario salvar(@RequestBody Prontuario prontuario) {
        return service.salvar(prontuario);
    }

    @PutMapping("/{id}")
    public Prontuario atualizar(@PathVariable Long id, @RequestBody Prontuario prontuario) {
        return service.atualizar(id, prontuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}