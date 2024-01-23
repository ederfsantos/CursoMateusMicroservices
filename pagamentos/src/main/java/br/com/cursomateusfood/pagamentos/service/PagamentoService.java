package br.com.cursomateusfood.pagamentos.service;

import br.com.cursomateusfood.pagamentos.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PagamentoService {

    private final PagamentoRepository repository;
    private final ModelMapper modelMapper;

}
