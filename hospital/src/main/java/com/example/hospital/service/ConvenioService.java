package com.example.hospital.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.dto.request.ConvenioRequestDTO;
import com.example.hospital.dto.response.ConvenioResponseDTO;
import com.example.hospital.mapper.ConvenioMapper;
import com.example.hospital.model.Convenio;
import com.example.hospital.repository.ConvenioRepository;

@Service
public class ConvenioService {

    @Autowired
    private ConvenioRepository repository;

    public List<ConvenioResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(ConvenioMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ConvenioResponseDTO buscarPorId(Long id) {
        Convenio convenio = repository.findById(id).orElse(null);
        return ConvenioMapper.toResponseDTO(convenio);
    }

    public ConvenioResponseDTO salvar(ConvenioRequestDTO dto) {
        Convenio convenio = ConvenioMapper.toEntity(dto);
        Convenio salvo = repository.save(convenio);
        return ConvenioMapper.toResponseDTO(salvo);
    }

    public ConvenioResponseDTO atualizar(Long id, ConvenioRequestDTO dto) {
        Convenio existente = repository.findById(id).orElse(null);
        if (existente != null) {
            ConvenioMapper.updateEntity(existente, dto);
            Convenio atualizado = repository.save(existente);
            return ConvenioMapper.toResponseDTO(atualizado);
        }
        return null;
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
