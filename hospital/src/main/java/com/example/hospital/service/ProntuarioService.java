package com.example.hospital.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hospital.model.Prontuario;
import com.example.hospital.repository.ProntuarioRepository;

@Service
public class ProntuarioService {

    @Autowired
    private ProntuarioRepository repository;

    public List<Prontuario> listarTodos() {
        return repository.findAll();
    }

    public Prontuario buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Prontuario salvar(Prontuario prontuario) {
        return repository.save(prontuario);
    }

    public Prontuario atualizar(Long id, Prontuario prontuario) {
        Prontuario existente = buscarPorId(id);
        if (existente != null) {
            prontuario.setId(id);
            return repository.save(prontuario);
        }
        return null;
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}