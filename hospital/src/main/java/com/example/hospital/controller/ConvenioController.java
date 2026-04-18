package com.example.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.hospital.model.Convenio;
import com.example.hospital.service.ConvenioService;

@RestController
@RequestMapping("/convenios")
public class ConvenioController {

    @Autowired
    private ConvenioService service;

    @GetMapping
    public List<Convenio> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Convenio buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Convenio salvar(@RequestBody Convenio convenio) {
        return service.salvar(convenio);
    }

    @PutMapping("/{id}")
    public Convenio atualizar(@PathVariable Long id, @RequestBody Convenio convenio) {
        return service.atualizar(id, convenio);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}