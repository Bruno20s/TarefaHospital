package com.example.hospital.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.dto.request.ConsultaRequestDTO;
import com.example.hospital.dto.response.ConsultaResponseDTO;
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
        Consulta consulta = repository.findById(id).orElse(null);
        return ConsultaMapper.toResponseDTO(consulta);
    }

    public ConsultaResponseDTO salvar(ConsultaRequestDTO dto) {
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId()).orElse(null);
        Medico medico = medicoRepository.findById(dto.getMedicoId()).orElse(null);

        Consulta consulta = ConsultaMapper.toEntity(dto, paciente, medico);
        Consulta salva = repository.save(consulta);
        return ConsultaMapper.toResponseDTO(salva);
    }

    public ConsultaResponseDTO atualizar(Long id, ConsultaRequestDTO dto) {
        Consulta existente = repository.findById(id).orElse(null);
        if (existente != null) {
            Paciente paciente = pacienteRepository.findById(dto.getPacienteId()).orElse(null);
            Medico medico = medicoRepository.findById(dto.getMedicoId()).orElse(null);

            ConsultaMapper.updateEntity(existente, dto, paciente, medico);
            Consulta atualizada = repository.save(existente);
            return ConsultaMapper.toResponseDTO(atualizada);
        }
        return null;
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
