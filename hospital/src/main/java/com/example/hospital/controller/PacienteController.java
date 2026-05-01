package com.example.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.hospital.dto.request.PacienteRequestDTO;
import com.example.hospital.dto.response.PacienteResponseDTO;
import com.example.hospital.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping
    public List<PacienteResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public PacienteResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public PacienteResponseDTO salvar(@RequestBody PacienteRequestDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public PacienteResponseDTO atualizar(@PathVariable Long id, @RequestBody PacienteRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
