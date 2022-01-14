package br.com.financas.financas.pessoais.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.financas.financas.pessoais.modelo.Conta;
import br.com.financas.financas.pessoais.modelo.TipoConta;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

	Page<Conta> findByTipoConta(TipoConta tipoConta, Pageable paginacao);
	
}
