package com.example.hospital.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hospital.model.Paciente;
import com.example.hospital.repository.PacienteRepository;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public List<Paciente> listarTodos() {
        return repository.findAll();
    }

    public Paciente buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Paciente salvar(Paciente paciente) {
        return repository.save(paciente);
    }

    public Paciente atualizar(Long id, Paciente paciente) {
        Paciente existente = buscarPorId(id);
        if (existente != null) {
            paciente.setId(id);
            return repository.save(paciente);
        }
        return null;
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}