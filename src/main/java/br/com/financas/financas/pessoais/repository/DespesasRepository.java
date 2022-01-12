package br.com.financas.financas.pessoais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.financas.financas.pessoais.modelo.Despesa;

public interface DespesasRepository  extends JpaRepository<Despesa, Integer> {

}
