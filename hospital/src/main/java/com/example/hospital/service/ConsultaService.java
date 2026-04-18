package com.example.hospital.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hospital.model.Consulta;
import com.example.hospital.repository.ConsultaRepository;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository repository;

    public List<Consulta> listarTodos() {
        return repository.findAll();
    }

    public Consulta buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Consulta salvar(Consulta consulta) {
        return repository.save(consulta);
    }

    public Consulta atualizar(Long id, Consulta consulta) {
        Consulta existente = buscarPorId(id);
        if (existente != null) {
            consulta.setId(id);
            return repository.save(consulta);
        }
        return null;
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}