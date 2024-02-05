package br.com.cursomateusfood.pagamentos.controller;

import br.com.cursomateusfood.pagamentos.dto.PagamentoDto;
import br.com.cursomateusfood.pagamentos.service.PagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/pagamentos")
@RequiredArgsConstructor
public class PagamentoController {

    private final PagamentoService service;

    @GetMapping
    public List<PagamentoDto> listarPagamentos() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDto> buscarPorId(@PathVariable @NotNull Long id) {
        PagamentoDto dto = service.getByID(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PagamentoDto> cadastrar(@RequestBody @Valid PagamentoDto dto, UriComponentsBuilder uri) {
        PagamentoDto pagamento = service.createPagamento(dto);
        var caminho = uri.path("/pagamentos/{id}").buildAndExpand(pagamento.getId()).toUri();
        return ResponseEntity.created(caminho).body(pagamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagamentoDto> atualizar(@PathVariable @NotNull Long id,
                                                  @RequestBody @Valid PagamentoDto dto) {
        PagamentoDto pagamentoAtualizado = service.updatePagamento(id, dto);
        return ResponseEntity.ok(pagamentoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PagamentoDto> excluir(@PathVariable @NotNull Long id){
        service.deletePagamento(id);
        return ResponseEntity.noContent().build();
    }

}