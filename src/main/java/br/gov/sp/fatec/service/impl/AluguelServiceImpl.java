package br.gov.sp.fatec.service.impl;

import br.gov.sp.fatec.domain.entity.Aluguel;
import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.mapper.AluguelMapper;
import br.gov.sp.fatec.domain.request.AluguelRequest;
import br.gov.sp.fatec.domain.request.AluguelUpdateRequest;
import br.gov.sp.fatec.domain.response.AluguelResponse;
import br.gov.sp.fatec.repository.AluguelRepository;
import br.gov.sp.fatec.service.AluguelService;
import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AluguelServiceImpl implements AluguelService {

    private final AluguelRepository aluguelRepository;
    private final AluguelMapper aluguelMapper;

    @Override
    public AluguelResponse save(AluguelRequest aluguelRequest) {
        return aluguelMapper.map(aluguelRepository.save(aluguelMapper.map(aluguelRequest)));
    }

    @Override
    public AluguelResponse findById(Long id) {
        return aluguelMapper.map(aluguelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Aluguel não encontrado")));
    }

    @Override
    public List<AluguelResponse> findAll() {
        return aluguelRepository.findAll().stream().map(aluguelMapper::map).toList();
    }

    @Override
    public void updateById(Long id, AluguelUpdateRequest aluguelUpdateRequest) {
        Aluguel aluguelAtualizado = aluguelMapper.map(aluguelUpdateRequest);
        Aluguel aluguel =
                aluguelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Aluguel não encontrado"));
        aluguel.setDatafim(aluguelAtualizado.getDatafim());
        aluguel.setDatainicio(aluguelAtualizado.getDatainicio());
        aluguel.setValor(aluguelAtualizado.getValor());
        aluguel.setCarro(aluguelAtualizado.getCarro());
        aluguel.setCliente(aluguelAtualizado.getCliente());
        aluguelRepository.save(aluguel);
    }

    @Override
    public void deleteById(Long id) {
        aluguelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID: " + id));
        aluguelRepository.deleteById(id);
    }
}
