package com.example.hospital.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.dto.request.ConsultaRequestDTO;
import com.example.hospital.dto.response.ConsultaResponseDTO;
import com.example.hospital.exception.ResourceNotFoundException;
import com.example.hospital.mapper.ConsultaMapper;
import com.example.hospital.model.Consulta;
import com.example.hospital.model.Medico;
import com.example.hospital.model.Paciente;
import com.example.hospital.repository.ConsultaRepository;
import com.example.hospital.repository.MedicoRepository;
import com.example.hospital.repository.PacienteRepository;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository repository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    public List<ConsultaResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(ConsultaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ConsultaResponseDTO buscarPorId(Long id) {
        Consulta consulta = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada com id: " + id));
        return ConsultaMapper.toResponseDTO(consulta);
    }

    public ConsultaResponseDTO salvar(ConsultaRequestDTO dto) {
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com id: " + dto.getPacienteId()));
        Medico medico = medicoRepository.findById(dto.getMedicoId())
                .orElseThrow(() -> new ResourceNotFoundException("Médico não encontrado com id: " + dto.getMedicoId()));

        Consulta consulta = ConsultaMapper.toEntity(dto, paciente, medico);
        Consulta salva = repository.save(consulta);
        return ConsultaMapper.toResponseDTO(salva);
    }

    public ConsultaResponseDTO atualizar(Long id, ConsultaRequestDTO dto) {
        Consulta existente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada com id: " + id));
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com id: " + dto.getPacienteId()));
        Medico medico = medicoRepository.findById(dto.getMedicoId())
                .orElseThrow(() -> new ResourceNotFoundException("Médico não encontrado com id: " + dto.getMedicoId()));

        ConsultaMapper.updateEntity(existente, dto, paciente, medico);
        Consulta atualizada = repository.save(existente);
        return ConsultaMapper.toResponseDTO(atualizada);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Consulta não encontrada com id: " + id);
        }
        repository.deleteById(id);
    }
}
