package br.com.financas.financas.pessoais.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.financas.financas.pessoais.modelo.Conta;
import br.com.financas.financas.pessoais.modelo.TipoConta;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

	Page<Conta> findByTipoConta(TipoConta tipoConta, Pageable paginacao);

	@Query("SELECT SUM(c.saldo) FROM Conta c")
	Optional<BigDecimal> SaldoTotal();

}
