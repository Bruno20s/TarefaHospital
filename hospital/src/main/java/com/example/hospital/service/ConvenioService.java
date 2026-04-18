package com.example.hospital.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hospital.model.Convenio;
import com.example.hospital.repository.ConvenioRepository;

@Service
public class ConvenioService {

    @Autowired
    private ConvenioRepository repository;

    public List<Convenio> listarTodos() {
        return repository.findAll();
    }

    public Convenio buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Convenio salvar(Convenio convenio) {
        return repository.save(convenio);
    }

    public Convenio atualizar(Long id, Convenio convenio) {
        Convenio existente = buscarPorId(id);
        if (existente != null) {
            convenio.setId(id);
            return repository.save(convenio);
        }
        return null;
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}