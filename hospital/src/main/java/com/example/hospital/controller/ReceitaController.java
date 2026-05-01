package com.example.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.hospital.dto.request.ReceitaRequestDTO;
import com.example.hospital.dto.response.ReceitaResponseDTO;
import com.example.hospital.service.ReceitaService;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaService service;

    @GetMapping
    public List<ReceitaResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ReceitaResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ReceitaResponseDTO salvar(@RequestBody ReceitaRequestDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public ReceitaResponseDTO atualizar(@PathVariable Long id, @RequestBody ReceitaRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
