package com.example.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.hospital.dto.request.ProntuarioRequestDTO;
import com.example.hospital.dto.response.ProntuarioResponseDTO;
import com.example.hospital.service.ProntuarioService;

@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {

    @Autowired
    private ProntuarioService service;

    @GetMapping
    public List<ProntuarioResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ProntuarioResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ProntuarioResponseDTO salvar(@RequestBody ProntuarioRequestDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public ProntuarioResponseDTO atualizar(@PathVariable Long id, @RequestBody ProntuarioRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
