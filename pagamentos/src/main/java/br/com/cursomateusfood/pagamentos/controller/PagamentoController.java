package br.com.cursomateusfood.pagamentos.controller;

import br.com.cursomateusfood.pagamentos.dto.PagamentoDto;
import br.com.cursomateusfood.pagamentos.service.PagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/pagamentos")
@RequiredArgsConstructor
public class PagamentoController {

    private final PagamentoService service;

    @GetMapping
    public List<PagamentoDto > listarPagamentos(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDto> buscarPorId(@PathVariable @NotNull Long id){
        PagamentoDto dto = service.getByID(id);
        return ResponseEntity.ok(dto);
    }
}
