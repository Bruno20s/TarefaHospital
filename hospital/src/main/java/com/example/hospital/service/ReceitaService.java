package com.example.hospital.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hospital.model.Receita;
import com.example.hospital.repository.ReceitaRepository;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository repository;

    public List<Receita> listarTodos() {
        return repository.findAll();
    }

    public Receita buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Receita salvar(Receita receita) {
        return repository.save(receita);
    }

    public Receita atualizar(Long id, Receita receita) {
        Receita existente = buscarPorId(id);
        if (existente != null) {
            receita.setId(id);
            return repository.save(receita);
        }
        return null;
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}