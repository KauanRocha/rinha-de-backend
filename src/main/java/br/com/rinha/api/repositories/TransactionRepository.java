package br.com.rinha.api.repositories;

import br.com.rinha.api.models.Transacoes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transacoes, Integer> {
    Optional<Transacoes> findFirstByClienteIdOrderByIdDesc(int clienteId);

    List<Transacoes> findFirst10ByClienteIdOrderByIdDesc(int clienteId);

}
