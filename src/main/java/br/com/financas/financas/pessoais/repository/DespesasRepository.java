package br.com.financas.financas.pessoais.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.financas.financas.pessoais.modelo.Despesa;
import br.com.financas.financas.pessoais.modelo.TipoDespesa;

public interface DespesasRepository  extends JpaRepository<Despesa, Integer> {

	Page<Despesa> findByTipoDespesa(TipoDespesa tipoDespesa, Pageable paginacao);
	
	Page<Despesa> findByDataPagamentoBetween(LocalDate primeiraData, LocalDate segundaData, Pageable paginacao);
	
}
