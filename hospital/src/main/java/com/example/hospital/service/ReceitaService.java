package com.example.hospital.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.dto.request.ReceitaRequestDTO;
import com.example.hospital.dto.response.ReceitaResponseDTO;
import com.example.hospital.exception.ResourceNotFoundException;
import com.example.hospital.mapper.ReceitaMapper;
import com.example.hospital.model.Consulta;
import com.example.hospital.model.Receita;
import com.example.hospital.repository.ConsultaRepository;
import com.example.hospital.repository.ReceitaRepository;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository repository;

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<ReceitaResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(ReceitaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ReceitaResponseDTO buscarPorId(Long id) {
        Receita receita = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Receita não encontrada com id: " + id));
        return ReceitaMapper.toResponseDTO(receita);
    }

    public ReceitaResponseDTO salvar(ReceitaRequestDTO dto) {
        Consulta consulta = consultaRepository.findById(dto.getConsultaId())
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada com id: " + dto.getConsultaId()));

        Receita receita = ReceitaMapper.toEntity(dto, consulta);
        Receita salva = repository.save(receita);
        return ReceitaMapper.toResponseDTO(salva);
    }

    public ReceitaResponseDTO atualizar(Long id, ReceitaRequestDTO dto) {
        Receita existente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Receita não encontrada com id: " + id));
        Consulta consulta = consultaRepository.findById(dto.getConsultaId())
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada com id: " + dto.getConsultaId()));

        ReceitaMapper.updateEntity(existente, dto, consulta);
        Receita atualizada = repository.save(existente);
        return ReceitaMapper.toResponseDTO(atualizada);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Receita não encontrada com id: " + id);
        }
        repository.deleteById(id);
    }
}
