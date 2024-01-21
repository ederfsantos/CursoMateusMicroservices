package br.com.cursomateusfood.pagamentos.repository;

import br.com.cursomateusfood.pagamentos.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento,Long> {


}
