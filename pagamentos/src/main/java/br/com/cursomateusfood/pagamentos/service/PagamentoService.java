package br.com.cursomateusfood.pagamentos.service;

import br.com.cursomateusfood.pagamentos.dto.PagamentoDto;
import br.com.cursomateusfood.pagamentos.model.Pagamento;
import br.com.cursomateusfood.pagamentos.model.Status;
import br.com.cursomateusfood.pagamentos.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PagamentoService {

    private final PagamentoRepository repository;
    private final ModelMapper modelMapper;

    public List<PagamentoDto> getAll(){
        return repository.findAll()
                .stream()
                .map(p->modelMapper.map(p,PagamentoDto.class))
                .collect(Collectors.toList());
    }

    public PagamentoDto getByID(Long id){
        Optional<Pagamento> optionalPagamento = repository.findById(id);
        Pagamento pagamento = optionalPagamento.orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(pagamento,PagamentoDto.class);
    }

    public PagamentoDto createPagamento(PagamentoDto dto){

        Pagamento pagamento = modelMapper.map(dto,Pagamento.class);
        pagamento.setStatus(Status.CRIADO);
        repository.save(pagamento);
        return modelMapper.map(pagamento,PagamentoDto.class);


    }
    public PagamentoDto updatePagamento(Long id,PagamentoDto dto){
        Pagamento pagamento = modelMapper.map(dto,Pagamento.class);
        pagamento.setId(id);
        pagamento = repository.save(pagamento);
        return modelMapper.map(pagamento,PagamentoDto.class);

    }

    public void deletePagamento(Long id){
        repository.deleteById(id);
    }

}
