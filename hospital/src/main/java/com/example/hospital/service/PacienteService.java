package com.example.hospital.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.dto.request.PacienteRequestDTO;
import com.example.hospital.dto.response.PacienteResponseDTO;
import com.example.hospital.mapper.PacienteMapper;
import com.example.hospital.model.Paciente;
import com.example.hospital.repository.PacienteRepository;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public List<PacienteResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(PacienteMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public PacienteResponseDTO buscarPorId(Long id) {
        Paciente paciente = repository.findById(id).orElse(null);
        return PacienteMapper.toResponseDTO(paciente);
    }

    public PacienteResponseDTO salvar(PacienteRequestDTO dto) {
        Paciente paciente = PacienteMapper.toEntity(dto);
        Paciente salvo = repository.save(paciente);
        return PacienteMapper.toResponseDTO(salvo);
    }

    public PacienteResponseDTO atualizar(Long id, PacienteRequestDTO dto) {
        Paciente existente = repository.findById(id).orElse(null);
        if (existente != null) {
            PacienteMapper.updateEntity(existente, dto);
            Paciente atualizado = repository.save(existente);
            return PacienteMapper.toResponseDTO(atualizado);
        }
        return null;
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
