package com.example.hospital.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.dto.request.ProntuarioRequestDTO;
import com.example.hospital.dto.response.ProntuarioResponseDTO;
import com.example.hospital.exception.ResourceNotFoundException;
import com.example.hospital.mapper.ProntuarioMapper;
import com.example.hospital.model.Paciente;
import com.example.hospital.model.Prontuario;
import com.example.hospital.repository.PacienteRepository;
import com.example.hospital.repository.ProntuarioRepository;

@Service
public class ProntuarioService {

    @Autowired
    private ProntuarioRepository repository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<ProntuarioResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(ProntuarioMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ProntuarioResponseDTO buscarPorId(Long id) {
        Prontuario prontuario = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prontuário não encontrado com id: " + id));
        return ProntuarioMapper.toResponseDTO(prontuario);
    }

    public ProntuarioResponseDTO salvar(ProntuarioRequestDTO dto) {
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com id: " + dto.getPacienteId()));

        Prontuario prontuario = ProntuarioMapper.toEntity(dto, paciente);
        Prontuario salvo = repository.save(prontuario);
        return ProntuarioMapper.toResponseDTO(salvo);
    }

    public ProntuarioResponseDTO atualizar(Long id, ProntuarioRequestDTO dto) {
        Prontuario existente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prontuário não encontrado com id: " + id));
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com id: " + dto.getPacienteId()));

        ProntuarioMapper.updateEntity(existente, dto, paciente);
        Prontuario atualizado = repository.save(existente);
        return ProntuarioMapper.toResponseDTO(atualizado);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Prontuário não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
