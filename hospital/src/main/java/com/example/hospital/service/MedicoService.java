package com.example.hospital.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hospital.model.Medico;
import com.example.hospital.repository.MedicoRepository;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    public List<Medico> listarTodos() {
        return repository.findAll();
    }

    public Medico buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Medico salvar(Medico medico) {
        return repository.save(medico);
    }

    public Medico atualizar(Long id, Medico medico) {
        Medico existente = buscarPorId(id);
        if (existente != null) {
            medico.setId(id);
            return repository.save(medico);
        }
        return null;
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}