package com.locadora.locadora_carros.service;

import com.locadora.locadora_carros.domain.Aluguel;
import com.locadora.locadora_carros.repository.AluguelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    @Autowired
    private final AluguelRepository aluguelRepository;

    public AluguelService(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    public List<Aluguel> listarTodos() {
        return aluguelRepository.findAll();
    }

    public Optional<Aluguel> buscarPorId(Long id) {
        return aluguelRepository.findById(id);
    }

    public Aluguel salvar(Aluguel aluguel) {
        return aluguelRepository.save(aluguel);
    }

    public void deletar(Long id) {
        aluguelRepository.deleteById(id);
    }
}
