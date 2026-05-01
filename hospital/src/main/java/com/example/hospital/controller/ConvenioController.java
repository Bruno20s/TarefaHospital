package com.example.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.hospital.dto.request.ConvenioRequestDTO;
import com.example.hospital.dto.response.ConvenioResponseDTO;
import com.example.hospital.service.ConvenioService;

@RestController
@RequestMapping("/convenios")
public class ConvenioController {

    @Autowired
    private ConvenioService service;

    @GetMapping
    public List<ConvenioResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ConvenioResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ConvenioResponseDTO salvar(@RequestBody ConvenioRequestDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public ConvenioResponseDTO atualizar(@PathVariable Long id, @RequestBody ConvenioRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
