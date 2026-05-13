package com.example.hospital.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.dto.request.MedicoRequestDTO;
import com.example.hospital.dto.response.MedicoResponseDTO;
import com.example.hospital.exception.ResourceNotFoundException;
import com.example.hospital.mapper.MedicoMapper;
import com.example.hospital.model.Medico;
import com.example.hospital.repository.MedicoRepository;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    public List<MedicoResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(MedicoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public MedicoResponseDTO buscarPorId(Long id) {
        Medico medico = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Médico não encontrado com id: " + id));
        return MedicoMapper.toResponseDTO(medico);
    }

    public MedicoResponseDTO salvar(MedicoRequestDTO dto) {
        Medico medico = MedicoMapper.toEntity(dto);
        Medico salvo = repository.save(medico);
        return MedicoMapper.toResponseDTO(salvo);
    }

    public MedicoResponseDTO atualizar(Long id, MedicoRequestDTO dto) {
        Medico existente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Médico não encontrado com id: " + id));
        MedicoMapper.updateEntity(existente, dto);
        Medico atualizado = repository.save(existente);
        return MedicoMapper.toResponseDTO(atualizado);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Médico não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
