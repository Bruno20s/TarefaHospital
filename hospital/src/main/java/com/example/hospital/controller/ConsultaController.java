package com.example.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.hospital.dto.request.ConsultaRequestDTO;
import com.example.hospital.dto.response.ConsultaResponseDTO;
import com.example.hospital.service.ConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @GetMapping
    public List<ConsultaResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ConsultaResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ConsultaResponseDTO salvar(@RequestBody ConsultaRequestDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public ConsultaResponseDTO atualizar(@PathVariable Long id, @RequestBody ConsultaRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
